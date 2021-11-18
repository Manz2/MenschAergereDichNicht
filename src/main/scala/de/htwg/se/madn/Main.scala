package de.htwg.se.madn

import model.{Player, Field, Home}
import Controller.Controller
import aview.Tui
import scala.io.StdIn.readLine

object Madn {
  @main def main: Unit = {
    println("Mensch  Aergere Dich nicht")
    var init: Array[String] = new Array[String](1)
    val home = new Home(init)
    val player = new Player(init)
    val field = new Field(1, init)
    val controller = new Controller(home, player, field)
    val tui = Tui(controller)
    print("Pro Spieler einen Buchstaben (mit Leertaste trennen): ")
    var Spieler = readLine()
    println("")
    print("Anzahl Figuren pro Spieler: ")
    var anzFig = readLine()
    println("")
    print("Anzahl2 Spielfelder: ")
    var Felderanz = readLine().toInt
    println("")

    var anzFig1 = anzFig.toInt
    var Felderanz1 = Felderanz.toInt
    tui.run(Spieler,anzFig1,Felderanz1)
  }
}
