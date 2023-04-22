package de.htwg.se.madn

import FieldComponent.FieldInterface
import FigureComponent.FigureInterface

class MoveCommand(figur:FigureInterface,Anzahl:Int,field:FieldInterface) extends Command{
  override def doStep: FieldInterface =  field.move(figur,Anzahl)

  override def undoStep: FieldInterface = field.move(figur,-Anzahl)

  override def redoStep: FieldInterface = field.move(figur,Anzahl)
}
