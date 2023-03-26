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

  def newGame(
    nPlayer : Int
  ): Unit = {
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

  def raus(figur:FigureInterface):Unit ={
    def inner(index:Int):Unit = {
      player = checkField(index)
      field = Field(field.data.updated(index,figur))
      player = Field(player.data.updated(index,Figure("",-1)))
    }
    figur.playerName match{
      case "A" =>inner(0)
      case "B" =>inner((field.data.size/4).toInt)
      case "C" =>inner(2*(field.data.size/4).toInt)
      case "D" =>inner(3*(field.data.size/4).toInt)
    }
  }

  // würfelt
  def throwDice : Int = scala.util.Random.nextInt(6) + 1

  // prüft ob alle spieler zuhause sind  
  def nochAlle(spieler:Char) : Boolean = player.data.count(_.playerName==spieler.toString) == 4

  // schickt Figur nach Hause, wenn vorhanden
  def checkField(index:Int):FieldInterface = if(field.data(index).playerName != "") backHome(index) else player

  //send the figure at the possition i back to the base 
  def backHome(index:Int):Field={
    val figure = field.data(index)
    figure.playerName match{
      case "A" => Field(player.data.updated(index,figure))
      case "B" => Field(player.data.updated(index+4,figure))
      case "C" => Field(player.data.updated(index+8,figure))
      case "D" => Field(player.data.updated(index+12,figure))
    } 
  }


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
  /*
   *try 3 times to leave the player field
   */

  def Alleda(spieler:Char): String = {
    var count = 0
    var out = ""

    while(count < 3){
      var x = throwDicec.toInt
      var z = player.figuren.size;
      var s = None: Option[String]
      var y = 0;
      if(x == 6){
        count = 3
        while(y<z){
          if(!player.figuren(y).equals(None)){
              if(player.figuren(y).get.charAt(0).equals(spieler)){
                s = player.figuren(y)
                player.figuren(y) = None: Option[String]
                y = z
              }
              y = y + 1
          }else{
            y = y + 1
          }
        }
        out = raus(s,spieler)  
      }else{
        out = "du hast es leider nicht raus geschafft\n"
        count = count + 1
      }
    }
    out
   
  }
*/

  /*
  /*
   * moves figure plfig dicev fields
   */
  def move(fig:Int,pl:Char,dicev:Int):String={
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
  }
  def reachedEnd(fig:Int,pl:Char,dicev:Int):Unit={
    val f = pl.toUpper.toString.concat(fig.toString)
    pl.toUpper match{
      case 'A' => //A erreicht home
        field.figuren(field.figuren.indexOf(Some(f)))= None: Option[String]
        home.figuren(fig-1) = Some(f)
      case _ =>
        states(f) = true
        val neu = field.figuren.indexOf(Some(f)) + dicev - field.figuren.size
        if(!field.figuren(neu).equals(None)){
          backHome(neu)
        }
        field.figuren(field.figuren.indexOf(Some(f)))= None: Option[String]
        field.figuren(neu) = Some(f)
    }  
  }*/
}

