package de.htwg.se.madn
package model.PlayerComponent
import model.FigureComponent.FigureInterface

trait PlayerInterface(val data: Vector[FigureInterface]) {
  def move(figur:Figure,anzahlFelder:Int): PlayerInterface
}
