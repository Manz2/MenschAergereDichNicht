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

class Tui(controller: ControllerInterface) extends Observer:
  controller.add(this)
  override def update: Unit =  println(controller.toString)
  def run = {
    print("Pro Spieler einen Buchstaben (mit Leertaste trennen): \n")
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
    var count = 0
    fieldpos.foreach(ins => {//Umwandeln?
      fieldpos(count) = None: Option[String]
      count = count + 1
    })
    //fieldpos(1) = Some("A1")
    //home
    count = 0
    val hpmepos: Array[Option[String]] = new Array[Option[String]](inserts.toArray.length)
    hpmepos.foreach(ins => {
      hpmepos(count) = None: Option[String]
      count = count + 1
    })
    
    println(controller.newGame(inserts.toArray, fieldpos, hpmepos))
    val size = inserts.length/anzFig.toInt
    val uebergabe = new Array[Char](size)
    count = 0
    for (a <- Spieler1) {
      if (a != ' ') {
          uebergabe(count) =  a
          count = count + 1
      }
    } 
    neueRunde(uebergabe,size)
    /*
    controller.domove(Some("A1"),3)
    controller.undo*/
    //println(controller.newGame(inserts.toArray, fieldpos, hpmepos))

  }
  
  def neueRunde(Spieler:Array[Char],Maennchen:Int) : Unit= {
    Spieler.foreach(player =>{
      println("neue Runde  Spieler "+ player + " ist an der Reihe")
      val r = controller.throwDicec
      println("Spieler " + player + " hat eine " + r + " gewuerfelt")
      //controller.field.figuren(1) = Some("A1")
      //println(controller.Runde(player,Maennchen))
    })
    //neueRunde(Spieler,Maennchen)
  }
  //override def update: Unit =  println(controller.toString)