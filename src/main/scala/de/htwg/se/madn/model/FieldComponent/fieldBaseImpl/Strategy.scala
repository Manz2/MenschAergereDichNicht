package de.htwg.se.madn
package model.FieldComponent.fieldBaseImpl
import model.FigureComponent.FigureInterface

trait Strategy {
  def move(figur:FigureInterface,anzahlFelder:Int) :FieldInterface
}
