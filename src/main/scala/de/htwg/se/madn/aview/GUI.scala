package de.htwg.se.madn
package aview
import Controller.Controller
import model.{Player, Field, Home}
import util.Observer
import scala.io.StdIn.readLine


class GUI(controller: Controller) extends Observer {
  controller.add(this)

  def top = new MainFrame {
   title = "Mensch ärgere dich nicht"
   object player extends TextField { columns = 5 }
   object fields extends TextField { columns = 5 }
   contents = new FlowPanel {
     contents += player
     contents += new Label(" Anzahl Spieler (2-4) :  ")
     border = Swing.EmptyBorder(15, 10, 10, 10)
   }
   listenTo(player)
   reactions += {
     case EditDone(`player`) =>
       val f = fahrenheit.text.toInt
   }
 }
}
override def update: Unit =  println(controller.toString)
