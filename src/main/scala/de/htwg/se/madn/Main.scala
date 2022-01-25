package de.htwg.se.madn

import com.google.inject.Guice
import de.htwg.se.madn.Controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.madn.Controller.controllerComponent.ControllerInterface
import model.PlayerComponent.PlayerInterface
import model.PlayerComponent.PlayerBaseImpl.Player
import model.HomeComponent.HomeInterface
import model.HomeComponent.HomeBaseImpl.Home
import model.FieldComponent.FieldInterface
import model.FieldComponent.fieldBaseImpl.Field
import aview.{Tui, GUI}
import scala.io.StdIn.readLine


object Madn {
  @main def main: Unit = {
    val injector = Guice.createInjector(new madnModule)
    val controller = injector.getInstance(classOf[ControllerInterface])
    println("Mensch aergere dich nicht")
    val tui = Tui(controller)
    val gui = new aview.GUI(controller)//comment for docker use then "docker build -t madn" and after "docker run -ti madn"
    var input: String = ""
    print("Game started\n")  
    input = readLine()
    tui.processInputLine(input)
    while (input != "q"){
      input = readLine()
      tui.processInputLine(input)
    } 
  }
}
