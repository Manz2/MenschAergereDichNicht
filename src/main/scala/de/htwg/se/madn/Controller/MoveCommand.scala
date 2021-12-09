package de.htwg.se.madn
package Controller

import model.{Player, Field, Home, Dice}
import util.Observable
import util.Command
import util.UndoManager

class MoveCommand(Figur:Option[String],Anzahl:Int,controller:Controller) extends Command{
  override def doStep: Unit =  controller.field.move(Figur,Anzahl)

  override def undoStep: Unit = controller.field.move(Figur,Anzahl)

  override def redoStep: Unit = controller.field.move(Figur,Anzahl)
}
