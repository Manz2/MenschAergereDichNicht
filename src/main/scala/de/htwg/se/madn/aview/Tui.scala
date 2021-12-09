package de.htwg.se.madn
package aview
import Controller.Controller
//import Controller.PutCommand
//import model.move
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
    print("Anzahl Spielfelder: ")
    var Felderanz = readLine()
    println("")
    printplayer(Spieler,anzFig,Felderanz)
  }
  def printplayer(Spieler:String,anzFig:String,Felderanz:String)={

  //Player
    var Spieler1 = Spieler.toCharArray
    val inserts = scala.collection.mutable.ArrayBuffer.empty[Option[String]]
    for (a <- Spieler1) {
      if (a != ' ') {
        for (b <- 1 until anzFig.toInt + 1) {
          val d = a.toString + b.toString
          Some(d)
          inserts += Some(d)
        }
      }
    } 
    //Field
    val fieldpos: Array[Option[String]] = new Array[Option[String]](Felderanz.toInt)//müssen mit none gefüllt werden 
    var count = 0;
    fieldpos.foreach(ins => {//Umwandeln?
      fieldpos(count) = None: Option[String]
      count = count + 1
    })
    fieldpos(1) = Some("A1")
    //home
    count = 0;
    val hpmepos: Array[Option[String]] = new Array[Option[String]](inserts.toArray.length)
    hpmepos.foreach(ins => {
      hpmepos(count) = None: Option[String]
      count = count + 1
    })
    
    println(controller.newGame(inserts.toArray, fieldpos, hpmepos))
    controller.domove(Some("A1"),3)
    controller.undo
    //println(controller.newGame(inserts.toArray, fieldpos, hpmepos))
  }
   override def update: Unit =  println(controller.toString)
  /*def analyseInput(input:String):Option[move] = 
    input match
      case "z" => PutCommand.doAndPubish(controller.redo); None
      case "y" => PutCommand.doAndPubish(controller.undo); None*/
 
