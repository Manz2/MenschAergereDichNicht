package de.htwg.se.madn
package model.FieldComponent.fieldBaseImpl
import model.FieldComponent.FieldInterface
import model.FigureComponent.FigureBaseImpl.Figure
import scala.annotation.switch

final case class Field(val data:Vector[Figure]) extends Strategy with FieldInterface {

  override def toString: String = {
    def inner(value: Figure) : String = if (!value.number == -1) value.toString else Some("   ")
    def row(figuren: Vector[Figure]): String ="|" + figuren.map(inner(_) + " |").toString
    ("+") + ("----+" * data.length) + "\n" + row(data) + "\n" + ("+") + ("----+" * data.length) + "\n"
  }

  def move(figur:Figure,anzahlFelder:Int): Field = {
    val index = data.indexOf(figur)
    index match{
      case -1 => Field(data)
      case _ => {
        val dataUpdated = data.updated(index,Figure("",-1))
        Field(dataUpdated.updated(index+anzahlFelder,figur))}
    }
  }
}
