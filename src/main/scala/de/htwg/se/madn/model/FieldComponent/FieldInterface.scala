package de.htwg.se.madn
package model.FieldComponent

trait FieldInterface {
  val figuren :  Array[Option[String]]
  def move(Figur:Option[String],Anzahl:Int): Option[String] 
}
