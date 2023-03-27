package de.htwg.se.madn
package Controller.controllerComponent.controllerBaseImpl

import com.google.inject.name.Names
import com.google.inject.{Guice, Inject}
import net.codingwell.scalaguice.InjectorExtensions._
import de.htwg.se.madn.madnModule
import model.FieldComponent.FieldInterface
import model.FieldComponent.fieldBaseImpl.Field
import de.htwg.se.madn.Controller.controllerComponent._
import util.UndoManager
import scala.util.{Try,Success,Failure}
import scala.util.Random
import scala.util.control.Breaks._
import scala.collection.mutable.Map
import model.fileIoComponent.FileIOInterface
import model.FigureComponent.FigureBaseImpl.Figure
import model.FigureComponent.FigureInterface

//case class Controller @Inject() (val Home:Home,val Field:Field,val Player:Player) extends ControllerInterface {
case class Controller () extends ControllerInterface {
  val undoManager = new UndoManager 
  /*
  val injector = Guice.createInjector(new madnModule)
  var field = injector.getInstance(classOf[FieldInterface])//Spielfeld
  var player = injector.getInstance(classOf[FieldInterface])//basisfeld wo die figuren warten
  var home = injector.getInstance(classOf[FieldInterface])//ziel feld
  val fileIo = injector.getInstance(classOf[FileIOInterface])
  */

  var field : FieldInterface = Field(Vector());
  var player: FieldInterface = Field(Vector());
  var home: FieldInterface = Field(Vector());

  def debug() = {
    println(player)
    println(field)
    println(home)
  }

  def newGame(nPlayer : Int): Unit = {
    def inner(spielername: String): List[Figure] = (1 until 5).map(idx => Figure(spielername,idx)).toList
    player = Field(Vector(List("A","B","C","D").take(nPlayer).map(inner(_)).flatten).flatten)
    field = Field(Vector.fill(20)(Figure("",-1)))
    home = Field(Vector.fill(nPlayer*4)(Figure("",-1)))
    notifyObservers
  }

  override def toString = field.toString + home.toString + player.toString
  
  def domove(figur:FigureInterface ,anzahl:Int): Unit = {
    player = checkField(field.data.indexOf(figur)+anzahl)
    field = undoManager.doStep(new MoveCommand(figur,anzahl,this))
    notifyObservers
  }

  def undo: Unit = {
    field = undoManager.undoStep(field)
    notifyObservers
  }

  def redo: Unit = {
    field = undoManager.redoStep(field)
    notifyObservers
  }

  def raus(spieler:String): FieldInterface={
    def inner(index:Int):Unit = {
      val figur = player.data.find(_.playerName==spieler.toString).get
      player = checkField(index)
      field = Field(field.data.updated(index,figur))
      player = Field(player.data.updated(player.data.indexOf(figur),Figure("",-1)))
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
  def nochAlle(spieler:Char) : Boolean = player.data.count(_.playerName==spieler.toString) == 4

  // schickt Figur nach Hause, wenn vorhanden
  def checkField(index:Int):FieldInterface = if(field.data(index).playerName != "") backHome(player)(index) else player

  //send the figure at the possition i back to the base Currying
  def backHome(space: FieldInterface)(index:Int) :FieldInterface = {
    val figure = field.data(index)
    figure.playerName match{
      case "A" => Field(space.data.updated(figure.number-1,figure))
      case "B" => Field(space.data.updated(figure.number-1+4,figure))
      case "C" => Field(space.data.updated(figure.number-1+8,figure))
      case "D" => Field(space.data.updated(figure.number-1+12,figure))
    } 
  }

  //try 3 times to leave the player field
  def Alleda(spieler:Char): Boolean = {
    val result = List.fill(3)(throwDice).contains(6)
    if (result) raus(spieler.toString)
    result  
  }

  // wenn Figur wiever >= Startfield ankommt wird die in das Home Field geschoben
  def reachedHome(figur:FigureInterface):FieldInterface={
    println(field.data.indexOf(figur))
    home = backHome(home)(field.data.indexOf(figur))
    field = Field(field.data.updated(field.data.indexOf(figur),Figure("",-1)))
    field
  }


  def reachedEnd(figur: FigureInterface, anzahl: Int): FieldInterface = {
    def inner(thisField: FieldInterface, thisAnzahl: Int): FieldInterface = {
      player = checkField(anzahl)
      Field(thisField.data.updated(anzahl,figur).updated(thisField.data.size-1,Figure("",-1)))
    }
    if (figur.playerName == "A") reachedHome(figur)
    else inner(Field(field.data.updated(field.data.indexOf(figur),Figure(figur.playerName,figur.number,true))),anzahl)
  }

  //Test




  /*
  def save: Unit = {
    fileIo.save(player,field,home)
    notifyObservers
  }
  def load: Unit = {
    player = fileIo.loadPlayer
    field = fileIo.loadField
    home = fileIo.loadHome
    notifyObservers
  }
  */

  


  /*
   * moves figure plfig dicev fields
   */
  def move(figur:FigureInterface,anzahl:Int):FieldInterface={
    // Ist eine Figur des Spielers im Startfeld
    val anyFigure = player.data.map(_.playerName).contains(figur.playerName)
    // Ist die Figur im Hauptfeld
    val InField= field.data.contains(figur)

    def outer(inField: Boolean): FieldInterface = {
      if (inField) field // Dummy
      else field
    }

    def inner(anzahl: Int, figur: FigureInterface) = {
      field = reachedEnd(figur,anzahl)
    }


    if(anzahl == 6 && anyFigure) raus(figur.playerName)
    else field // Dummy

    /*
    var nochDa = false
    var out = ""
    var erster = None: Option[String]
    val f = pl.toUpper.toString.concat(fig.toString)
    player.figuren.foreach(ins => {
      if(!ins.equals(None)){
        if(ins.get.charAt(0)==pl.toUpper){
          if(nochDa == false){
            erster = ins
          }
          nochDa = true
        }
     }
    })



    
    if(dicev == 6  && nochDa == true){
      raus(erster,pl.toUpper)
      player.figuren(player.figuren.indexOf(erster)) = None: Option[String]
      notifyObservers
      out = "noch einer Raus"
    }else{
      if(!field.figuren.contains(Some(f))){
        out = f + " ist nicht im Feld waehle eine andere Figur"
      }else{
        if(field.figuren.indexOf(Some(f))+dicev >= field.figuren.size){//figur erreicht ende des feldes
          reachedEnd(fig,pl,dicev)
          out = f.toString
          notifyObservers
        }else if(field.figuren.indexOf(Some(f))+dicev >= field.figuren.size/4 && pl == 'b'&& states(f)==true){//B erreicht home
          home.figuren(4+fig-1) = Some(f)
          field.figuren(field.figuren.indexOf(Some(f)))= None: Option[String]
          notifyObservers
        }else if(field.figuren.indexOf(Some(f))+dicev >= field.figuren.size/4*2 && pl == 'c'&& states(f)==true){//C erreicht home
          home.figuren(8+fig-1) = Some(f)
          field.figuren(field.figuren.indexOf(Some(f)))= None: Option[String]
          notifyObservers
        }else if(field.figuren.indexOf(Some(f))+dicev >= field.figuren.size/4*3 && pl == 'd'&& states(f)==true){//D erreicht home
          home.figuren(12+fig-1) = Some(f)
          field.figuren(field.figuren.indexOf(Some(f)))= None: Option[String]
          notifyObservers
        }else{
          if(!field.figuren(field.figuren.indexOf(Some(f))+dicev).equals(None)){
            backHome(field.figuren.indexOf(Some(f))+dicev)
          }
          domove(Some(f),dicev)
          out = f.toString
        }
        var I = Some(pl.toUpper.toString.concat("1"))
        var II = Some(pl.toUpper.toString.concat("2"))
        var III = Some(pl.toUpper.toString.concat("3"))
        var IV = Some(pl.toUpper.toString.concat("4"))

        var counter = 0
        home.figuren.foreach(ins => {
          if(!ins.equals(None)){
            if(ins.get.charAt(0).equals(pl.toUpper)){
              counter = counter + 1
            }
          }
        })
        if(counter == 4){
          out = "Spieler " + pl.toUpper + " hat gewonnen"
        }
      }
      
    }
    out
  */
  
  }
}

