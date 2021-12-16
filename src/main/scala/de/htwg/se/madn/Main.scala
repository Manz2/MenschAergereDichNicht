package de.htwg.se.madn

import Controller.controllerComponent.controllerBaseImpl.Controller
import model.PlayerComponent.PlayerInterface
import model.PlayerComponent.PlayerBaseImpl.Player
import model.HomeComponent.HomeInterface
import model.HomeComponent.HomeBaseImpl.Home
import model.FieldComponent.FieldInterface
import model.FieldComponent.fieldBaseImpl.Field
import aview.{Tui, GUI}


object Madn {
  @main def main: Unit = {
    println("Mensch aergere dich nicht")
      var init: Array[Option[String]] = new Array[Option[String]](1)
      var inito: Array[Option[String]] = new Array[Option[String]](1)
      val controller = new Controller(new Home(init), new Player(init), new Field(inito))
      val tui = Tui(controller)
      //val gui = GUI(controller)
      /*println("Welcome to our game: if you want to play, tab play, tab any button to exit");
      var select = scala.io.StdIn.readLine()
      object Select {
        var choosen = if (select == "play") game else exit
        def game = 
          gui.top
          tui.run
          
        def exit = sys.exit(0)
      }*/
      val gui = new aview.GUI(controller)
      tui.run
      //Select.choosen //Strategy Pattern
  }
}
