package de.htwg.se.madn
package Controller.cotrollerComponent.controllerMockImpl


import model.PlayerComponent.PlayerInterface
import model.HomeComponent.HomeInterface
import model.FieldComponent.FieldInterface
import de.htwg.se.madn.Controller.controllerComponent._
import util.UndoManager
import scala.util.{Try,Success,Failure}
import scala.util.Random
import scala.util.control.Breaks._

class Controller(var home: HomeInterface, var player: PlayerInterface, var field: FieldInterface) extends ControllerInterface {
  def newGame(inserts: Array[Option[String]],fieldpositions: Array[Option[String]],homepositions: Array[Option[String]]) : Unit = {}
  def domove(Figur:Option[String],Anzahl:Int): Unit = {}
  def undo: Unit = {}
  def redo: Unit = {}
  def nochAlle(spieler:Char) : Boolean = false
  def throwDicec : String = "1"


  def Alleda(spieler:Char): String  = ""
  def Runde(player:Array[Char],Maennchen:Int):Unit = {}
  def move(fig:Int,pl:Char,dicev:Int):String = ""
  def backHome(i:Int):Unit={}
  def reachedEnd(fig:Int,pl:Char,dicev:Int):Unit={}
  def raus(s:Option[String],spieler:Char):String =""
}
