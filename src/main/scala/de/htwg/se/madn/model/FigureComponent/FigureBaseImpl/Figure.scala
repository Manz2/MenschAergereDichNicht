package de.htwg.se.madn
package model.FigureComponent.FigureBaseImpl
import model.FigureComponent.FigureInterface
final case class Figure(val playerName:String, val number:Int) extends FigureInterface {
    override def toString: String = playerName + number
}
