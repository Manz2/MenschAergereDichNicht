package de.htwg.se.madn
package Controller

//import model.move
import model.{Player, Field, Home, Dice}
import util.Observable
import util.UndoManager //java.swing.undooManager

case class Controller(var home: Home, var player: Player, var field: Field)
    extends Observable {
  /*def doAndPubish(doThis:Move=>Field,move:Move) = 
    field = doThis(move)
    notifyObservers*/
  //def put(move:Move):Field = UndoManager.doStep(field,PutCommand(move))
  def newGame(
      inserts: Array[String],
      fieldpositions: Array[Option[String]],
      homepositions: Array[String]
  ) = {
    field = new Field(fieldpositions)
    player = new Player(inserts)
    home = new Home(homepositions)
    val dices = Dice("six")
    val random = dices.throwTheDice
    println("Random digit: " + random)
    notifyObservers
  }
  override def toString = field.toString + home.toString + player.toString
}

