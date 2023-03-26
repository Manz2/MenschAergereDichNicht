package de.htwg.se.madn
package aview
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

  def round(player:Char)={

    print("Spieler "+ player.toUpper+" ist an der Reihe\n")
    var alle = controller.nochAlle(player.toUpper)
    if(alle == true){
      print(player.toUpper + " darf 3x wuerfeln\n")
      print(controller.Alleda(player.toUpper))
      turn = player
    } else{
      diceVal =  controller.throwDicec
      print(player.toUpper + " hat eine "+ diceVal +" gewuerfelt\n")
      println("Mit welcher Figur moechtest du Fahren (1-4)")
      turn = player
    }
  }


  def processInputLine(input:String) = {
    input match {
      case "n1" => controller.newGame(1)//new Game with one Player
      case "n2" => controller.newGame(2)//new Game with two Players
      case "n3" => controller.newGame(3)//new Game with three Players
      case "n4" => controller.newGame(4)//new Game with four Players
      case "q"  => sys.exit(0)
      case "a"  => round('a')
      case "b"  => round('b')
      case "c"  => round('c')
      case "d"  => round('d')
      case "1"  => println(controller.move(1,turn,diceVal.toInt))
      case "2"  => println(controller.move(2,turn,diceVal.toInt))
      case "3"  => println(controller.move(3,turn,diceVal.toInt))
      case "4"  => println(controller.move(4,turn,diceVal.toInt))
      case "save"  => controller.save
      case "load"  => controller.load
      case _ => 
    }
  }