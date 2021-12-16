package de.htwg.se.madn
package Controller.controllerComponent.controllerBaseImpl

import model.PlayerComponent.PlayerInterface
import model.PlayerComponent.PlayerBaseImpl.Player
import model.HomeComponent.HomeInterface
import model.HomeComponent.HomeBaseImpl.Home
import model.FieldComponent.FieldInterface
import model.FieldComponent.fieldBaseImpl.Field
import de.htwg.se.madn.Controller.controllerComponent._
import util.UndoManager
import scala.util.{Try,Success,Failure}
import scala.util.Random
import scala.util.control.Breaks._

case class Controller(var home: HomeInterface, var player: PlayerInterface, var field: FieldInterface)
    extends ControllerInterface {
  val undoManager = new UndoManager 
  def newGame(
      inserts: Array[Option[String]],
      fieldpositions: Array[Option[String]],
      homepositions: Array[Option[String]]
  ) = {
    field = new Field(fieldpositions)
    player = new Player(inserts)
    home = new Home(homepositions)
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
  def throwDicec : String= {
    val r = scala.util.Random
    val e = r.nextInt(6)+1  
    e.toString
  }

  def Runde(player:Array[Char],Maennchen:Int)= { 
    player.foreach(p => {
      if(nochAlle(p,Maennchen)){    
        for( k <- 0 to 3){
          val random = throwDicec.toInt
          if(random == 6){
            p match {
              case 'A' => 
            }
          }
        }
      }/*else{
        val random = throwDicec.toInt

      }*/
      })
  }
  
}

