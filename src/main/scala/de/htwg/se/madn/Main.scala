package de.htwg.se.madn

import model.{Player, Field, Home}
import Controller.Controller
import aview.{Tui, GUI}

object Madn {
  @main def main: Unit = {
    println("Mensch aergere dich nicht")
      var init: Array[Option[String]] = new Array[Option[String]](1)
      var inito: Array[Option[String]] = new Array[Option[String]](1)
      val controller = new Controller(new Home(init), new Player(init), new Field(inito))
      val tui = Tui(controller)
      val gui = GUI(controller)
      gui.top
      println("Welcome to our game: if you want to play, tab play, tab any button to exit");
      var select = scala.io.StdIn.readLine()
      object Select {
        var choosen = if (select == "play") game else exit
        def game = tui.run
        def exit = sys.exit(0)
      }
      Select.choosen //Strategy Pattern
  }
}
