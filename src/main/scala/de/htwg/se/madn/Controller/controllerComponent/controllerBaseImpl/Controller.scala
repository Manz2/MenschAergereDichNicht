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

  //def newGame(
      //inserts: Array[Option[String]],
      //fieldpositions: Array[Option[String]],
      //homepositions: Array[Option[String]]
  //) = {
    //field.figuren = fieldpositions
    //player.figuren = inserts
    //home.figuren = homepositions
    //notifyObservers
  //}

  def newGame(
    nPlayer : Int
  ): Unit = {
    def inner(spielername: String): List[Figure] = (1 until 5).map(idx => Figure(spielername,idx)).toList

    //println(Vector(List("A","B").map(inner(_)).flatten).flatten)
    //player = Field(   Vector(   List("A","B","C","D").take(nPlayer)   .map(inner(_).flatten).flatten ))
    player = Field(Vector(List("A","B","C","D").take(nPlayer).map(inner(_)).flatten).flatten)
    println(player)

    notifyObservers
  }
  override def toString = field.toString + home.toString + player.toString

  /*
  def domove(figur:Option[String],Anzahl:Int): Unit = {
    undoManager.doStep(new MoveCommand(figur,Anzahl,this))
    notifyObservers
  }

  def undo: Unit = {
    undoManager.undoStep
    notifyObservers
  }

  def redo: Unit = {
    undoManager.redoStep
    notifyObservers
  }
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

  def nochAlle(spieler:Char) : Boolean = {
    var counter = 0
    player.figuren.foreach(ins => {
      if(!ins.equals(None)){
        if(ins.get.charAt(0).equals(spieler)){
          counter = counter + 1
        }
      }
    })
    if(counter == 4){
      true
    }else{
      false

    }  
  }

  def throwDicec : String= {
    val r = scala.util.Random
    val e = r.nextInt(6)+1  
    e.toString
  }
  
  /*
   *try 3 times to leave the playeer field
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
  /*
   * send the figure at the possition i back to the base 
   */
  def backHome(i:Int):Unit={
    val fig = field.figuren(i).get
    val pl = fig.charAt(0)
    println(fig.charAt(1))
    val pos = fig.charAt(1).asDigit -1
    pl match{
      case 'A' => 
        player.figuren(pos) = Some(fig)//hier fehler
      case 'B' => 
        player.figuren(4+pos) = Some(fig)
      case 'C' => 
        player.figuren(8+pos) = Some(fig)
      case 'D' => 
        player.figuren(12+pos) = Some(fig)
    }  
    field.figuren(i) = None: Option[String]
  }
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
  }
  def raus(s:Option[String],spieler:Char):String ={
    var out = ""
    spieler match{
      case 'A' => 
        if(!field.figuren(0).equals(None)){
          backHome(0)
        }
        field.figuren(0) = s
        out = "du hast es raus geschafft\n"
        notifyObservers
        
      case 'B' => 
        if(!field.figuren(field.figuren.size/4).equals(None)){
          backHome(field.figuren.size/4)
        }
        field.figuren(field.figuren.size/4) = s
        states(s.get) = false
        out = "du hast es raus geschafft\n"
        notifyObservers
      case 'C' =>
        if(!field.figuren(field.figuren.size/4*2).equals(None)){
          backHome(field.figuren.size/4*2)
        }
        states(s.get) = false
        field.figuren(field.figuren.size/4*2) = s
        out = "du hast es raus geschafft\n"
        notifyObservers
      case 'D' =>
        if(!field.figuren(field.figuren.size/4*3).equals(None)){
          backHome(field.figuren.size/4*3)
        }
        states(s.get) = false
        field.figuren(field.figuren.size/4*3) = s
        out = "du hast es raus geschafft\n"
        notifyObservers
        
      case _ =>
        print("fail")
    } 
    out
  }
  */
}

