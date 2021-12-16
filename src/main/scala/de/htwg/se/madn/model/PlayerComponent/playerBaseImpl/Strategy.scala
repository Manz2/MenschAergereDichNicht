package de.htwg.se.madn
package model.PlayerComponent.PlayerBaseImpl

trait Strategy {
  def move(Figur:Option[String],Anzahl:Int) :Option[String]
}

