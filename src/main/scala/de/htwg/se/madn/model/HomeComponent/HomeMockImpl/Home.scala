package de.htwg.se.madn
package model.HomeComponent.HomeMockImpl
import model.HomeComponent.HomeInterface
import model.FieldComponent.fieldBaseImpl.Strategy
class field(positions: Array[Option[String]]) extends Strategy with HomeInterface {
  val figuren = positions
  def move(Figur:Option[String],Anzahl:Int): Option[String] = Some("-1")
}

