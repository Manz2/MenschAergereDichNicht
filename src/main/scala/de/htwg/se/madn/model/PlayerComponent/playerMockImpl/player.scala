package de.htwg.se.madn
package model.PlayerComponent.PlayerMockImpl
import model.FieldComponent.fieldBaseImpl.Strategy
import model.PlayerComponent.PlayerInterface
class Player(positions: Array[Option[String]]) extends Strategy with PlayerInterface {

  var x: Array[Option[String]] = new Array[Option[String]](10)
      var count1 = 0
      x.foreach(ins => {
      x(count1) = None: Option[String]
      count1 = count1 + 1
      })

  var figuren = x
  def move(Figur:Option[String],Anzahl:Int): Option[String] = Some("-1")
}

