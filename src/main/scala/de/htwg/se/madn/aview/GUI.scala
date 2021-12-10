package de.htwg.se.madn
package aview
import Controller.Controller
import aview.{Tui}
import model.{Player, Field, Home, Dice}
import util.Observer
import scala.io.StdIn.readLine
import scala.swing._
import scala.swing.BorderPanel
import scala.swing.event._
import java.awt.TextArea
import scala.util.Random

class GUI(controller: Controller) extends MainFrame with Observer {

  controller.add(this)

  var exchangeval = "A"

  override def update: Unit = {
    spielfeld.text = ""
    spielfeld.text = controller.toString
    dice.text = controller.throwDicec
    exchange.text = exchangeval
    repaint
  }

  

  val fieldpos: Array[Option[String]] = new Array[Option[String]](20)//40 

    var count = 0
    fieldpos.foreach(ins => {
      fieldpos(count) = None: Option[String]
      count = count + 1
    })

  object spielfeld extends TextPane {
    font = new Font("Consolas", 0, 19)
    preferredSize = new Dimension(1500, 350)
  }

  object player extends TextField { columns = 4 }
  object dice extends TextField { columns = 4 }
  object exchange extends TextField { columns = 1 }
  var spieler123 = new Array[Char](1)

   title = "Mensch ärgere dich nicht"
   iconImage = toolkit.getImage("dice.jpg")
   
   object Figur extends TextField { columns = 4 }
   
   var start = new Button("START")
   var wuerfel = new Button("WÜRFEL")
   var rundebutton = new Button("NEXTE RUNDE")
   var playerLabel = new Label("Anzahl Spieler: ")
   var FigurLabel = new Label("Welche Figur soll laufen? ")
   var exchangeLabel = new Label("Dieser Spieler ist dran: ")
   //var diceLabel = new Label("Welche Figur soll laufen? ")
   contents = new BoxPanel(Orientation.Vertical){
    contents += new FlowPanel {
      contents += playerLabel 
      contents += player
      contents += start}
    contents += spielfeld
    contents += new FlowPanel{
      contents += wuerfel
      contents += dice
        border = Swing.EmptyBorder(0,20,0,0)
      contents += FigurLabel
      contents += Figur
      contents += exchangeLabel
      contents += exchange
      contents += rundebutton
      border = Swing.EmptyBorder(15, 10, 10, 10)
    }
      border = Swing.EmptyBorder(15, 10, 10, 10)
    }
   listenTo(start,rundebutton,wuerfel)
   reactions += {
     case ButtonClicked(start) => startGame  
     case ButtonClicked(rundebutton) => neueRunde
     case ButtonClicked(wuerfel) => controller.throwDicec
    } 
   //size = new Dimension(300,100)
   centerOnScreen
   visible = true

  def startGame = {
    val inserts = scala.collection.mutable.ArrayBuffer.empty[Option[String]]
    spieler123 = new Array[Char](player.text.toInt)
       val Spielerbank = Array('A','B','C','D')
       var count = 0;
       spieler123.foreach(ins => {
        spieler123(count) = Spielerbank(count) 
        count = count + 1
        })
        count = 0
        val hpmepos: Array[Option[String]] = new Array[Option[String]](player.text.toInt*4)
          hpmepos.foreach(ins => {
          hpmepos(count) = None: Option[String]
          count = count + 1
        })
       for (a <- spieler123) {
        for (b <- 1 until 5) {
          val d = a.toString + b.toString
          Some(d)
          inserts += Some(d)
        }
       }
       controller.newGame(inserts.toArray, fieldpos, hpmepos)
  }
  
  def neueRunde = {
    controller.Runde(spieler123,4)
  }
}
