package de.htwg.se.madn
package model.FieldComponent.fieldMockImpl
import model.FieldComponent.FieldInterface
import model.FieldComponent.fieldBaseImpl.Strategy
class field(positions: Array[Option[String]]) extends Strategy with FieldInterface {
  val figuren = positions
  def move(Figur:Option[String],Anzahl:Int): Option[String] = Some("-1")
}
