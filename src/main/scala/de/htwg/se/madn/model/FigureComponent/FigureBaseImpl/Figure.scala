package de.htwg.se.madn
package model.FigureComponent.FigureBaseImpl
import model.FigureComponent.FigureInterface
final case class Figure(override val playerName:String, override val number:Int, override val state:Boolean=false) extends FigureInterface(playerName,number,state) {
    override def toString: String = playerName + number
}
