package de.htwg.se.madn
package aview
import Controller.Controller
import model.{Player, Field, Home, Dice}
import util.Observer
import scala.io.StdIn.readLine
import scala.swing._


class GUI(controller: Controller) extends Observer {
  controller.add(this)

  def top = new MainFrame {
   title = "Mensch ärgere dich nicht"
   object player extends TextField { columns = 4 }
   object dice extends TextField { columns = 1 }
   val button = new Button("klick mich")
   contents = new FlowPanel {
     contents += player
     contents += new Label(" Anzahl Spieler (2-4) :  ")
     contents += dice
     contents += button
     contents += new Label(" gewürfelt")
     border = Swing.EmptyBorder(15, 10, 10, 10)
   }
   listenTo(player)
   listenTo(button)
   reactions += {
     case ButtonClicked(`button`) =>
       println("Mouse clicked at " + e.point)
     case EditDone(`player`) =>
       val f = fahrenheit.text.toInt
   }
 }
}
override def update: Unit =  println(controller.toString)
