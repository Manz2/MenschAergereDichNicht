package Documents.Htwg.se.MADN.MenschAergereDichNicht
package aview
import Controller.Controller
import model.{Player, Field, Home}
import util.Observer
import scala.io.StdIn.readLine

class Tui(controller: Controller) extends Observer:
  controller.add(this)
  def run = {
  print("Pro Spieler einen Buchstaben (mit Leertaste trennen): ")
  var Spieler = readLine()
  val SpielerChar = Spieler.toCharArray
  println("")
  print("Anzahl Figuren pro Spieler: ")
  var anzFig = readLine()
  println("")
  print("Anzahl2 Spielfelder: ")
  var Felderanz = readLine().toInt
  println("")

  //Player
  val inserts = scala.collection.mutable.ArrayBuffer.empty[String]
  for (a <- SpielerChar) {
    if (a != ' ') {
      for (b <- 1 until anzFig.toInt + 1) {
        val d = a.toString + b.toString
        inserts += d
      }
    }
  } 
  //val inserts = SpielerChar.map(e=> if(e.equals(" ")) "" else e)

  var insertsArray = inserts.toArray

  //Field
  var fieldpos: Array[String] = new Array[String](Felderanz)
  //home
  var hpmepos: Array[String] = new Array[String](insertsArray.length)

  println(controller.newGame(insertsArray, fieldpos, hpmepos))
}
  override def update: Unit =  println(controller.toString)

