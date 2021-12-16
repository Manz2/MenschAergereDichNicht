package de.htwg.se.madn
package model.HomeComponent.HomeBaseImpl

trait Strategy {
  def move(Figur:Option[String],Anzahl:Int) :Option[String]
}

