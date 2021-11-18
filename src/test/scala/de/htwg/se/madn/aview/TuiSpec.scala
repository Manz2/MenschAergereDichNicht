package de.htwg.se.madn
package aview
import aview.Tui
import model.{Player, Field, Home}
import Controller.Controller
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class TUISpec extends AnyWordSpec with Matchers:
  "A MADN TUI" should {
    "create a new game  array on input 'A B 2 2'" in {
        var z: Array[String] = new Array[String](2)
        val smallfield = new Field(2,z)
        val smallHomefield = new Home(z)
        val smallPlayerfield = new Player(z)
        val controller = new Controller(smallHomefield,smallPlayerfield,smallfield)
        val tui = Tui(controller)
        tui.run should be(new Controller.newGame(z,z,z))
    }
  }


