package de.htwg.se.madn
package Controller
<<<<<<< HEAD
import model.DiceBuilder
import model.{Player, Field, Home}
=======

import model.{Player, Field, Home, Dice}
>>>>>>> b868cb5d8fdc4315998e394451d5323a7ec221cf
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
<<<<<<< HEAD
    var random = new DiceBuilder.fairDice(true).Numeyes(6)
    print(random)
=======
    val dices = Dice("six")
    val random = dices.throwTheDice
    println("Random digit: " + random)
>>>>>>> b868cb5d8fdc4315998e394451d5323a7ec221cf
    notifyObservers
  }
  override def toString = field.toString + home.toString + player.toString
}
