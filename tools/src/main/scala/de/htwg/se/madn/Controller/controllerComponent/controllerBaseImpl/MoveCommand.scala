package de.htwg.se.madn
package Controller.controllerComponent.controllerBaseImpl 

import FieldComponent.FieldInterface
//import util.Observable
//import util.Command
//import util.UndoManager
import FigureComponent.FigureInterface

class MoveCommand(figur:FigureInterface,Anzahl:Int,controller:Controller) extends Command{
  override def doStep: FieldInterface =  controller.field.move(figur,Anzahl)

  override def undoStep: FieldInterface = controller.field.move(figur,-Anzahl)

  override def redoStep: FieldInterface = controller.field.move(figur,Anzahl)
}
