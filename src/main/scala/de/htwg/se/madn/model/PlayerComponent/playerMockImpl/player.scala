package de.htwg.se.madn
package model.PlayerComponent.PlayerMockImpl
import model.FieldComponent.fieldBaseImpl.Strategy
import model.PlayerComponent.PlayerInterface
class Player(positions: Array[Option[String]]) extends Strategy with PlayerInterface {
  val figuren = positions
  def move(Figur:Option[String],Anzahl:Int): Option[String] = Some("-1")
}

