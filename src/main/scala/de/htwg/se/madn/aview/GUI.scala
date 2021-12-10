package de.htwg.se.madn
package aview
import Controller.Controller
import model.{Player, Field, Home, Dice}
import util.Observer
import scala.io.StdIn.readLine
import scala.swing._
import scala.swing.BorderPanel
import scala.swing.event._

class GUI(controller: Controller) extends Observer {
  controller.add(this)

  def top = new MainFrame {
   title = "Mensch ärgere dich nicht"
   iconImage = toolkit.getImage("dice.jpg")
   //object player extends TextField { columns = 4 }
   //object dice extends TextField { columns = 4 }
   var mainMenu = new Label("Start Game")
   var ananiSikerim = new Button("Click me")
   var closeGame = new Label("Cancel Game")
   var orospu = new Button("Click me")
   contents = new FlowPanel {
     contents += mainMenu 
     contents += closeGame
     contents += ananiSikerim
     contents += orospu
     //contents += new ImagePanel("dice.jpg")
     border = Swing.EmptyBorder(15, 10, 10, 10)
   }
   listenTo(ananiSikerim)
   listenTo(orospu)
   reactions += {
     case ButtonClicked(`ananiSikerim`) =>
       sys.exit(0)
     case ButtonClicked(`orospu`) =>
       println("starting Game...")
   }
   size = new Dimension(500,500)
   centerOnScreen
   visible = true
 }
  override def update: Unit =  println(controller.toString)
}
