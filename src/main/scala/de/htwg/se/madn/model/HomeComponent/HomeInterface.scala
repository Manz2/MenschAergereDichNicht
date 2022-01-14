package de.htwg.se.madn
package model.HomeComponent

trait HomeInterface {
  var figuren :  Array[Option[String]]
  def move(Figur:Option[String],Anzahl:Int): Option[String] 
}


