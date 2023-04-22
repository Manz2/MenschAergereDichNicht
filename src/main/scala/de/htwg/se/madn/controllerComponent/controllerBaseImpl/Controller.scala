package de.htwg.se.madn
package Controller.controllerComponent.controllerBaseImpl 



import com.google.inject.name.Names
import com.google.inject.{Guice, Inject}
import net.codingwell.scalaguice.InjectorExtensions._
import de.htwg.se.madn.FieldComponent.FieldInterface
import de.htwg.se.madn.FieldComponent.fieldBaseImpl.Field
import de.htwg.se.madn.Controller.controllerComponent._
import scala.util.{Try,Success,Failure}
import scala.util.Random
import scala.util.control.Breaks._
import scala.collection.mutable.Map
import FigureComponent.FigureBaseImpl.Figure
import FigureComponent.FigureInterface
import de.htwg.se.madn.Command
import play.api.libs.json._
import java.io.{File,PrintWriter}
import scala.io.Source
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives.*
import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn
import play.api.libs.json._
import scala.concurrent.Future
import akka.http.scaladsl.unmarshalling.Unmarshal

case class Controller () extends ControllerInterface {

  var field : FieldInterface = Field(Vector());
  var player: FieldInterface = Field(Vector());
  var home: FieldInterface = Field(Vector());
  val fileIOServer = "http://localhost:8080/fileio"
  val commandServer = "http://localhost:8081/command"

  def newGame(nPlayer : Int): Unit = {
    def inner(spielername: String): List[Figure] = (1 until 5).map(idx => Figure(spielername,idx)).toList
    player = Field(Vector(List("A","B","C","D").take(nPlayer).map(inner(_)).flatten).flatten)
    field = Field(Vector.fill(20)(Figure("",-1)))
    home = Field(Vector.fill(nPlayer*4)(Figure("",-1)))
    notifyObservers
  }

  def save:Unit = {
    implicit val system:ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")

    val executionContext: ExecutionContextExecutor = system.executionContext
    given ExecutionContextExecutor = executionContext

    val responseFuture: Future[HttpResponse] = Http().singleRequest(HttpRequest(
      method = HttpMethods.POST,
      uri = fileIOServer + "/save",
      entity = generateJson()
      ))
  }

  def load:Unit = {
    implicit val system:ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")

    val executionContext: ExecutionContextExecutor = system.executionContext
    given ExecutionContextExecutor = executionContext

    val responseFuture: Future[HttpResponse] = Http().singleRequest(HttpRequest(uri = fileIOServer + "/load"))

    responseFuture
      .onComplete {
        case Failure(_) => sys.error("Failed getting Json")
        case Success(value) => {
          Unmarshal(value.entity).to[String].onComplete {
            case Failure(_) => sys.error("Failed unmarshalling")
            case Success(value) => {
              val json: JsValue = Json.parse(value)
              loadJson(json)
              notifyObservers
            }
          }
        }
      }
    notifyObservers
  }

  override def toString = field.toString + home.toString + player.toString
  
  def domove(figur:FigureInterface ,anzahl:Int): FieldInterface = {
    checkField(field.data.indexOf(figur)+anzahl) match {
      case Success(res) => player = res
      case Failure(res) => player
    }
    implicit val system:ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")

    val executionContext: ExecutionContextExecutor = system.executionContext
    given ExecutionContextExecutor = executionContext

    val responseFuture: Future[HttpResponse] = Http().singleRequest(HttpRequest(
      method = HttpMethods.POST,
      uri = commandServer + "/doMove",
      entity = generateDoMoveJson(figur,anzahl)
      ))

    responseFuture
      .onComplete{
        case Failure(_) => sys.error("Failed getting Json")
        case Success(value) => {
          Unmarshal(value.entity).to[String].onComplete{
            case Failure(_) => sys.error("Failed unmarshalling")
            case Success(value) => {
                val json: JsValue = Json.parse(value)
                val field_ = (json\ "Field").as[List[String]]
                field = Field(Vector(field_.map(f => if (f == "-1") Figure("",-1) else Figure(f.charAt(0).toString,f.charAt(1).toString.toInt))).flatten)
            }
          }
        }
      }
      notifyObservers
      field
    //rest(generateDoMoveJson(figur,anzahl))
    //undoManager.doStep(new MoveCommand(figur,anzahl,this))
  }




  def generateDoMoveJson(figur:FigureInterface ,anzahl:Int): String={
    val fieldField : Vector[String] = field.data.map(f => f.playerName + f.number)
    val anzahl_ : String = anzahl.toString
    val figur_ : String = figur.toString
    val jsObj: JsValue = Json.obj(
      "Field" -> Json.toJson(fieldField),
      "Anzahl" -> Json.toJson(anzahl_),
      "Figur" -> Json.toJson(figur_)
    )
    jsObj.toString
  }

  def undo: FieldInterface = {
    //field = undoManager.undoStep(field)//""
    notifyObservers
    field
  }

  def redo: FieldInterface = {
    //field = undoManager.redoStep(field)
    notifyObservers
    field
  }



  def raus(spieler:String): FieldInterface={
    def inner(index:Int):FieldInterface = {
      val figur = player.data.find(_.playerName==spieler.toString).get
      checkField(index) match {
        case Success(res) => player = res
        case Failure(res) => player
      }
      field = Field(field.data.updated(index,figur))
      player = Field(player.data.updated(player.data.indexOf(figur),Figure("",-1)))
      player
    }
    spieler match{
      case "A" =>inner(0)
      case "B" =>inner((field.data.size/4).toInt)
      case "C" =>inner(2*(field.data.size/4).toInt)
      case "D" =>inner(3*(field.data.size/4).toInt)
    }
    player
  }

  // würfelt
  def throwDice : Int = scala.util.Random.nextInt(6) + 1

  // prüft ob alle spieler zuhause sind  
  def nochAlle(spieler:String) : Boolean = player.data.count(_.playerName==spieler) == 4

  // schickt Figur nach Hause, wenn vorhanden
  def checkField(index: Int): Try[FieldInterface] = Try {
    if (field.data(index).playerName != "") {
      backHome(player)(index)
    } else {
      player
    }
  }

  //send the figure at the possition i back to the base Currying
  def backHome(space: FieldInterface)(index:Int) :FieldInterface = {
    val figure = field.data(index)
    figure.playerName match{
      case "A" => Field(space.data.updated(figure.number-1,Figure(figure.playerName,figure.number,false)))
      case "B" => Field(space.data.updated(figure.number-1+4,Figure(figure.playerName,figure.number,false)))
      case "C" => Field(space.data.updated(figure.number-1+8,Figure(figure.playerName,figure.number,false)))
      case "D" => Field(space.data.updated(figure.number-1+12,Figure(figure.playerName,figure.number,false)))
    } 
  }

  //try 3 times to leave the player field
  def Alleda(spieler:String): Boolean = {
    val result = List.fill(3)(throwDice).contains(6)
    if (result) raus(spieler)
    notifyObservers
    result  
  }

  // wenn Figur wieder >= Startfield ankommt wird die in das Home Field geschoben
  def reachedHome(figur:FigureInterface):FieldInterface={
    home = backHome(home)(field.data.indexOf(figur))
    field = Field(field.data.updated(field.data.indexOf(figur),Figure("",-1)))
    notifyObservers
    field
  }

  def reachedEnd(figur: FigureInterface, anzahl: Int): FieldInterface = {
    def inner(thisField: FieldInterface, thisAnzahl: Int,thisFigur:FigureInterface): FieldInterface = {
      checkField(anzahl) match {
        case Success(res) => player = res
        case Failure(res) => player
      }
      Field(thisField.data.updated(anzahl,thisFigur).updated(field.data.indexOf(figur),Figure("",-1)))
    }
    if (figur.playerName == "A") reachedHome(figur)
    else{
      val fig = Figure(figur.playerName,figur.number,true)
      inner(Field(field.data.updated(field.data.indexOf(figur),fig)),anzahl,fig)
    } 
  }

  def anybodyWone(thisHome:FieldInterface):Option[String] = 
    thisHome.data.map(_.playerName).groupBy(identity).find((_, letters) => letters.length == 4).map((letter, _) => letter)

  def getFigureFromField(player:String,nummer:Int): FigureInterface= {
    val fig = field.data.find(a => a.playerName == player && a.number == nummer)
    if(fig != None) fig.get else Figure("X",-1)
    }

  // moves figure plfig dicev fields
  def move(figur:FigureInterface,anzahl:Int):FieldInterface={
    // Ist eine Figur des Spielers im Startfeld
    val anyFigure = player.data.map(_.playerName).contains(figur.playerName)
    // Ist die Figur im Hauptfeld
    val InField= field.data.contains(figur)

    def outer(inField: Boolean): FieldInterface = {
      if (inField) inner(anzahl,figur)
      else field
    }

    def inner(anzahl: Int, figur: FigureInterface) = {
      if(field.data.indexOf(figur)+anzahl >= field.data.size) reachedEnd(figur,anzahl-(field.data.size -field.data.indexOf(figur) ))
      else{
        if(isHome(figur,anzahl)) reachedHome(figur);
        else domove(figur,anzahl)
      }   
    }

     def isHome(thatFigur:FigureInterface, anzahl:Int): Boolean ={
      thatFigur.playerName match{
          case "A" =>false
          case "B" =>(field.data.indexOf(thatFigur)+anzahl >= ((field.data.size/4).toInt)) && thatFigur.state == true
          case "C" =>(field.data.indexOf(thatFigur)+anzahl >= (2*(field.data.size/4).toInt)) && thatFigur.state == true
          case "D" =>(field.data.indexOf(thatFigur)+anzahl >= (3*(field.data.size/4).toInt)) && thatFigur.state == true
          }
    }

    if(anzahl == 6 && anyFigure) raus(figur.playerName)
    else {
      field = outer(InField)
      }
    notifyObservers
    field
  }

  def loadJson(jsString: JsValue): Unit = {
    val field_ = (jsString \ "Field").as[List[String]]
    field = Field(Vector(field_.map(f => if (f == "-1") Figure("",-1) else Figure(f.charAt(0).toString,f.charAt(1).toString.toInt))).flatten)
    val fieldPlayer_ = (jsString \ "Player").as[List[String]]
    player = Field(Vector(fieldPlayer_.map(f => if (f == "-1") Figure("",-1) else Figure(f.charAt(0).toString,f.charAt(1).toString.toInt))).flatten)
    val fieldHome_ = (jsString \ "Home").as[List[String]]
    home = Field(Vector(fieldHome_.map(f => if (f == "-1") Figure("",-1) else Figure(f.charAt(0).toString,f.charAt(1).toString.toInt))).flatten)
  }
  def generateJson(): String={
    val fieldField : Vector[String] = field.data.map(f => f.playerName + f.number)
    val fieldPlayer : Vector[String] = player.data.map(f => f.playerName + f.number)
    val fieldHome : Vector[String] = home.data.map(f => f.playerName + f.number)
    val jsObj: JsValue = Json.obj(
      "Field" -> Json.toJson(fieldField),
      "Player" -> Json.toJson(fieldPlayer),
      "Home" -> Json.toJson(fieldHome)
    )
    jsObj.toString
  }
}

