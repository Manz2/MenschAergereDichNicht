package de.htwg.se.madn

import com.google.inject.Guice
import de.htwg.se.madn.Controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.madn.Controller.controllerComponent.ControllerInterface
import model.FieldComponent.FieldInterface
import model.FieldComponent.fieldBaseImpl.Field
import aview.{Tui, GUI}
import scala.io.StdIn.readLine
import model.FigureComponent.FigureBaseImpl.Figure
import scala.collection.immutable.LazyList.cons


object Madn {
  @main def main: Unit = {
    /*
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
    */

    val controller = Controller()
    controller.newGame(3)
    val figur = controller.player.data(4)
    //controller.debug()
    //controller.raus(figur)
    //controller.debug()
    controller.field  = Field(controller.field.data.updated(19,figur))
    //controller.domove(figur,3)
    //controller.debug()
    //controller.undo
    //controller.debug()
    //controller.redo
    //controller.debug()
    //controller.player = Field(controller.player.data.updated(0,Figure("",-1)))
    //controller.debug()
    //println(controller.nochAlle('B'))
    //println(controller.throwDice)
    //controller.debug()
    //controller.debug()
    //println(controller.Alleda('C'))
    //controller.raus("B")
    //controller.debug()
    //controller.raus("B")
    //controller.debug()
    //controller.raus("B")
    //controller.debug()
    controller.debug()
    controller.reachedEnd(figur,3)
    controller.debug()



  }
}
