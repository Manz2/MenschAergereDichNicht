package de.htwg.se.madn
package FieldComponent

import FigureComponent.FigureInterface
import java.lang.reflect.Field

trait FieldInterface(val data: Vector[FigureInterface]) {
  def move(figur:FigureInterface,anzahlFelder:Int): FieldInterface
}

