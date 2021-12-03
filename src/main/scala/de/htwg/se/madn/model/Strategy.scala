package de.htwg.se.madn
package model

trait Strategy {
  def move(Figur:Option[String],Anzahl:Int) :String 
}
