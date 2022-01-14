package de.htwg.se.madn
package model.PlayerComponent

trait PlayerInterface {
  var figuren :  Array[Option[String]]
  def move(Figur:Option[String],Anzahl:Int): Option[String] 
}
