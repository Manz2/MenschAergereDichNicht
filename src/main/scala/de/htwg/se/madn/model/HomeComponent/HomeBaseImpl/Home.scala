package de.htwg.se.madn
package model.HomeComponent.HomeBaseImpl
import model.HomeComponent.HomeInterface
import model.FigureComponent.FigureBaseImpl.Figure
import scala.collection.View.Single
// Ziel Feld

final case class Home(val data: Vector[Figure]) extends Strategy with HomeInterface {

 override def toString: String = {
    def inner(value: Figure) : String = if (!value.number == -1) value.toString else Some("   ")
    def row(figuren: Vector[Figure]): String ="|" + figuren.map(inner(_) + " |").toString
    ("+") + ("----+" * data.length) + "\n" + row(data) + "\n" + ("+") + ("----+" * data.length) + "\n"
  }

  def move(figur:Figure,anzahlFelder:Int): Home = {
    val index = data.indexOf(figur)
    index match{
      case -1 => Home(data)
      case _ => {
        val dataUpdated = data.updated(index,Figure("",-1))
        Home(dataUpdated.updated(index+anzahlFelder,figur))}
    }
  }
  
}
