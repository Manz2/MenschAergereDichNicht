package de.htwg.se.madn

import model.{Player, Field, Home}
import util.{Observer,Observable}
import Controller.Controller
import aview.{Tui}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MainSpec extends AnyWordSpec with Matchers{
  "The madn main class" should {
    "create a new tui" in{
      var init: Array[String] = new Array[String](1)
      val home = new Home(init)
      val player = new Player(init)
      val field = new Field(1, init)
      val controller = new Controller(home, player, field)
      val tui = Tui(controller)
      var Spieler = "A B"
      var anzFig = 2
      var Felderanz = 2

      var anzFig1 = anzFig.toInt
      var Felderanz1 = Felderanz.toInt
      tui.run(Spieler,anzFig1,Felderanz1)
    }
  }
}
