package de.htwg.se.madn
package Controller.controllerComponent.controllerBaseImpl

import model.FieldComponent.FieldInterface
import util.Observable
import util.Command
import util.UndoManager
import model.FigureComponent.FigureInterface

class MoveCommand(figur:FigureInterface,Anzahl:Int,controller:Controller) extends Command{
  override def doStep: Unit =  controller.field.move(figur,Anzahl)

  override def undoStep: Unit = controller.field.move(figur,-Anzahl)

  override def redoStep: Unit = controller.field.move(figur,Anzahl)
}
