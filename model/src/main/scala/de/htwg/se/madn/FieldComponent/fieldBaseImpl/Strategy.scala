package de.htwg.se.madn
package FieldComponent.fieldBaseImpl
import FigureComponent.FigureInterface
import FieldComponent.FieldInterface

trait Strategy {
  def move(figur:FigureInterface,anzahlFelder:Int,status:Boolean) :FieldInterface
}
