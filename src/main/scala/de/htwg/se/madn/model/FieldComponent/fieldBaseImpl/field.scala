package de.htwg.se.madn
package model.FieldComponent.fieldBaseImpl

import model.FieldComponent.FieldInterface
import model.FigureComponent.FigureBaseImpl.Figure
import model.FigureComponent.FigureInterface
import scala.annotation.switch


case class Field(override val data:Vector[FigureInterface]) extends FieldInterface(data) {

  override def toString: String = {
    def inner(value: FigureInterface) : String = if (!(value.number == -1)) value.toString() else "  "
    def row(figuren: Vector[FigureInterface]): String ="|" + figuren.map(" " + inner(_) + " |").mkString
    ("+") + ("----+" * data.length) + "\n" + row(data) + "\n" + ("+") + ("----+" * data.length) + "\n"
  }

  def move(figur:FigureInterface,anzahlFelder:Int): Field = {
    val index = data.indexOf(figur)
    println(index)
    index match{
      case -1 => Field(data)
      case _ => {
        val dataUpdated = data.updated(index,Figure("",-1))
        Field(dataUpdated.updated(index+anzahlFelder,figur))
      }
    }
  }
}
