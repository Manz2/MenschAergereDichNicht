package de.htwg.se.madn
package aview
//import Controller.PutCommand
//import model.move
import model.PlayerComponent.PlayerInterface
import model.HomeComponent.HomeInterface
import model.FieldComponent.FieldInterface
import scala.util.{Try,Success,Failure}
import util.Observer
import scala.io.StdIn.readLine
import scala.util.Random
import Controller.controllerComponent.ControllerInterface
import scala.io.StdIn.readLine

class Tui(controller: ControllerInterface) extends Observer:
  controller.add(this)
  override def update: Unit =  println(controller.toString)
  var diceVal = "";
  var turn = 'A'

  def startGame(anzahl:Int) = {
    val inserts = scala.collection.mutable.ArrayBuffer.empty[Option[String]]
    var spieler123 = new Array[Char](anzahl)
    val fieldpos: Array[Option[String]] = new Array[Option[String]](20)//40 
    var count1 = 0
    fieldpos.foreach(ins => {
      fieldpos(count1) = None: Option[String]
      count1 = count1 + 1
    })
       val Spielerbank = Array('A','B','C','D')
       var count = 0;
       spieler123.foreach(ins => {
        spieler123(count) = Spielerbank(count) 
        count = count + 1
        })
        count = 0
        val hpmepos: Array[Option[String]] = new Array[Option[String]](anzahl*4)
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
  def round(player:Char)={

    print("Spieler "+ player.toUpper+" ist an der Reihe\n")
    var alle = controller.nochAlle(player.toUpper)
    if(alle == true){
      print(player.toUpper + " darf 3x wuerfeln\n")
      print(controller.Alleda(player.toUpper))
    } else{
      diceVal =  controller.throwDicec
      print(player.toUpper + " hat eine "+ diceVal +" gewuerfelt\n")
      println("Mit welcher Figur moechtest du Fahren (1-4)")
      turn = player
    }
  }


  def processInputLine(input:String) = {
    input match {
      case "n1" => startGame(1)//new Game with one Player
      case "n2" => startGame(2)//new Game with two Players
      case "n3" => startGame(3)//new Game with three Players
      case "n4" => startGame(4)//new Game with four Players
      case "q"  => sys.exit(0)
      case "a"  => round('a')
      case "b"  => round('b')
      case "c"  => round('c')
      case "d"  => round('d')
      case "1"  => println(controller.move(1,turn,diceVal.toInt))
      case "2"  => println(controller.move(2,turn,diceVal.toInt))
      case "3"  => println(controller.move(3,turn,diceVal.toInt))
      case "4"  => println(controller.move(4,turn,diceVal.toInt))
      case _ => 
    }
  }