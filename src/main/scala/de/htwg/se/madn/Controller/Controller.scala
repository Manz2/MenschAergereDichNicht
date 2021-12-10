package de.htwg.se.madn
package Controller

import model.{Player, Field, Home, Dice}
import util.Observable
import util.UndoManager
import scala.util.{Try,Success,Failure}
import scala.util.Random
import scala.util.control.Breaks._

case class Controller(var home: Home, var player: Player, var field: Field)
    extends Observable {
  val undoManager = new UndoManager 
  def newGame(
      inserts: Array[Option[String]],
      fieldpositions: Array[Option[String]],
      homepositions: Array[Option[String]]
  ) = {
    field = new Field(fieldpositions)
    player = new Player(inserts)
    home = new Home(homepositions)
<<<<<<< HEAD
=======
    val dices = Dice("six")
    val random = dices.throwTheDice(6)
    random match {
      case Success(v) => new Random().nextInt(v) + 1
      case Failure(f) => println(f.getMessage)
    }

    println("Random digit: " + random.get)
>>>>>>> 56ed035e2f76cb93a8df995b353dd388e72d018a
    notifyObservers
  }
  override def toString = field.toString + home.toString + player.toString

  def domove(Figur:Option[String],Anzahl:Int): Unit = {
    undoManager.doStep(new MoveCommand(Figur,Anzahl,this))
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

  def nochAlle(spieler:Char,Maennchen:Int) : Boolean = {
    var counter = 0
    player.figuren.foreach(ins => {
      if(ins.get.charAt(0).equals(spieler)){
        counter = counter + 1
      }
    })
    if(counter == Maennchen){
      true
    }else{
      false

    }  
  }

  def neueRunde(player:Char,Maennchen:Int) : String = { 
    var Ausgabe = " "
    val dices = Dice("six")

    if(nochAlle(player,Maennchen)){
          Ausgabe = "Spieler "+ player.toString + " Darf 3x wuerfeln" ;
          //breakable{
          for( k <- 0 to 3){
            val random = dices.throwTheDice(6)
            random match {
            case Success(v) => new Random().nextInt(v) + 1
            case Failure(f) => println(f.getMessage)
            }
            Ausgabe = Ausgabe +"\n"+"gewuerfelt: " + random.get;
            if(random.get == 6){//würfel funktioniert nochnicht
              Ausgabe = Ausgabe + "\n"+"du darfst raus";
              //break
            }
          }
        //}
        }else{
          Ausgabe = "Spieler "+ player.toString + " Darf 1x wuerfeln ";
        }
        Ausgabe
      }
}

