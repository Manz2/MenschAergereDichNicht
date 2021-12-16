package de.htwg.se.madn
package model.FieldComponent.fieldBaseImpl

trait Strategy {
  def move(Figur:Option[String],Anzahl:Int) :Option[String]
}
