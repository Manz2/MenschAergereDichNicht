package de.htwg.se.madn
package model.PlayerComponent.PlayerBaseImpl
import model.FigureComponent.FigureInterface

trait Strategy {
  def move(figur:FigureInterface,anzahlFelder:Int) :PlayerInterface
}

