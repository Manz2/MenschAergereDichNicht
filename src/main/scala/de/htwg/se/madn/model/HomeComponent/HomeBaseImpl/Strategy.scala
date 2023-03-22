package de.htwg.se.madn
package model.HomeComponent.HomeBaseImpl
import model.FigureComponent.FigureInterface

trait Strategy {
  def move(figur:FigureInterface,anzahlFelder:Int) :HomeInterface
}

