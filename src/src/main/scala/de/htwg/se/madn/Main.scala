package de.htwg.se.madn

import com.google.inject.Guice
import de.htwg.se.madn.Controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.madn.Controller.controllerComponent.ControllerInterface
import FieldComponent.FieldInterface
import FieldComponent.fieldBaseImpl.Field
import scala.io.StdIn.readLine
import FigureComponent.FigureBaseImpl.Figure
import scala.collection.immutable.LazyList.cons
import scala.util.{Try,Success,Failure}


object Madn {
  @main def main: Unit = {
    //val injector = Guice.createInjector(new madnModule)
    //val controller = injector.getInstance(classOf[ControllerInterface])
    val controller = Controller()

    println("Mensch aergere dich nicht")
    val tui = Tui(controller)
    //val gui = new GUI(controller)//comment for docker use then "docker build -t madn" and after "docker run -ti madn"
    var input: String = ""
    print("Game started123\n")  
    input = readLine()
    tui.processInputLine(input)
    while (input != "q"){
      input = readLine()
      tui.processInputLine(input)
    }
  }
}
