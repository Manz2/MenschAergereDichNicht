package de.htwg.se.madn
package Controller

import model.{Player, Field, Home, Dice}
import util.Observable
import model.move
import util.Command
import util.UndoManager

import scala.annotation.meta.field
class PutCommand(move:Move) extends Command[Field] {
  override def doStep(field: Field) = field.move()
  override def undoStep(field: Field) = field.move()
  override def undoStep(field: Field) = field.move()
}
