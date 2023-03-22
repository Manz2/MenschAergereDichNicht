package de.htwg.se.madn
package model.PlayerComponent.PlayerBaseImpl
import model.FigureComponent.FigureBaseImpl.Figure
import model.PlayerComponent.PlayerInterface

final case class Player(val data:Vector[Figure]) extends Strategy with PlayerInterface {
  
  override def toString: String = {
    def inner(value: Figure) : String = if (!value.number == -1) value.toString else Some("   ")
    def row(figuren: Vector[Figure]): String ="|" + figuren.map(inner(_) + " |").toString
    ("+") + ("----+" * data.length) + "\n" + row(data) + "\n" + ("+") + ("----+" * data.length) + "\n"
  }

  def move(figur:Figure,anzahlFelder:Int): Player = {
    val index = data.indexOf(figur)
    index match{
      case -1 => Player(data)
      case _ => {
        val dataUpdated = data.updated(index,Figure("",-1))
        Player(dataUpdated.updated(index+anzahlFelder,figur))}
    }
  }
}
