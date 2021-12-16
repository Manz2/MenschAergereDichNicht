package de.htwg.se.madn
package Controller.controllerComponent.controllerBaseImpl

import model.PlayerComponent.PlayerInterface
import model.HomeComponent.HomeInterface
import model.FieldComponent.FieldInterface
import util.Observable
import util.Command
import util.UndoManager

class MoveCommand(Figur:Option[String],Anzahl:Int,controller:Controller) extends Command{
  override def doStep: Unit =  controller.field.move(Figur,Anzahl)

  override def undoStep: Unit = controller.field.move(Figur,-Anzahl)

  override def redoStep: Unit = controller.field.move(Figur,Anzahl)
}
