package de.htwg.se.madn
package Controller

import model.{Player, Field, Home, Dice}
import util.Observable
import util.UndoManager
import scala.util.{Try,Success,Failure}
import scala.util.Random

case class Controller(var home: Home, var player: Player, var field: Field)
    extends Observable {
  /*def doAndPubish(doThis:move=>Field,Figur:Option[String],Anzahl:Int) = 
    field = doThis(move)
    notifyObservers*/
  /*def put(Figur:Option[String],Anzahl:Int):Field = 
    UndoManager.doStep(field,PutCommand("A1",2))
    notifyObservers*/
  /*def executeAndNotify(command: List[String] => ChessCommand, args: List[String]): Unit = {
  field = putCommand.doStep(command(args))
  notifyObservers
  }*/
  val undoManager = new UndoManager 
  def newGame(
      inserts: Array[Option[String]],
      fieldpositions: Array[Option[String]],
      homepositions: Array[Option[String]]
  ) = {
    field = new Field(fieldpositions)
    player = new Player(inserts)
    home = new Home(homepositions)
    val dices = Dice("six")
    val random = dices.throwTheDice(6)
    random match {
      case Success(v) => new Random().nextInt(v) + 1
      case Failure(f) => println(f.getMessage)
    }

    println("Random digit: " + random)
    notifyObservers
  }
  override def toString = field.toString + home.toString + player.toString

  def setmove: Unit = {
    undoManager.doStep
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
}

