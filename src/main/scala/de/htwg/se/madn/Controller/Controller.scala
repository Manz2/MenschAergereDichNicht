package de.htwg.se.madn
package Controller
import model.DiceBuilder
import model.{Player, Field, Home}
import util.Observable

case class Controller(var home: Home, var player: Player, var field: Field)
    extends Observable {
  def newGame(
      inserts: Array[String],
      fieldpositions: Array[String],
      homepositions: Array[String]
  ) = {
    field = new Field(fieldpositions)
    player = new Player(inserts)
    home = new Home(homepositions)
    var random = new DiceBuilder.fairDice(true).Numeyes(6)
    print(random)
    notifyObservers
  }
  override def toString = field.toString + home.toString + player.toString
}
