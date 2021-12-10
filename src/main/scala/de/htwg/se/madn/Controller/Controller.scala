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

