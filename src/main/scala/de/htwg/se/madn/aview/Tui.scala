package de.htwg.se.madn
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
    println("")
    print("Anzahl Figuren pro Spieler: ")
    var anzFig = readLine()
    println("")
    print("Anzahl2 Spielfelder: ")
    var Felderanz = readLine().toInt
    println("")
  }
  def printplayer(Spieler:String,anzFig:String,Felderanz:String)={

  //Player
    var Spieler1 = Spieler.toCharArray
    val inserts = scala.collection.mutable.ArrayBuffer.empty[String]
    for (a <- Spieler1) {
      if (a != ' ') {
        for (b <- 1 until anzFig.toInt + 1) {
          val d = a.toString + b.toString
          inserts += d
        }
      }
    } 

    //Field
    var fieldpos: Array[String] = new Array[String](Felderanz.toInt)
    //home
    var hpmepos: Array[String] = new Array[String](inserts.toArray.length)

    println(controller.newGame(inserts.toArray, fieldpos, hpmepos))
}
  override def update: Unit =  println(controller.toString)
