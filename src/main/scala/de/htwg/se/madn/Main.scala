package de.htwg.se.madn

import model.{Player, Field, Home}
import Controller.Controller
import aview.Tui
import scala.io.StdIn.readLine

object Madn {
  @main def main: Unit = {
    println("Mensch  Aergere Dich nicht")
      var init: Array[String] = new Array[String](1)
      val controller = new Controller(new Home(init), new Player(init), new Field(1, init))
      val tui = Tui(controller)
      tui.run
  }
}
