package de.htwg.se.madn
package model.HomeComponent
import model.FigureComponent.FigureInterface

trait HomeInterface(val data: Vector[FigureInterface]) {
  def move(figur:Figure,anzahlFelder:Int): HomeInterface
}


