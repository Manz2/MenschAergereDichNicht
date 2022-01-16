package de.htwg.se.madn
package util

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import util.UndoManager

class CommandSpec extends AnyWordSpec with Matchers {
    "a Command" should {
      
      "try to undo a step" in {
        val undoManager = new UndoManager 
        undoManager.undoStep
        undoManager.undoStack should equal(Nil)

      }
      "try to redo a step" in {
        val undoManager = new UndoManager 
        undoManager.redoStep
        undoManager.redoStack should equal(Nil)
      }

    }
}