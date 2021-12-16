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
  def nochAlle(spieler:Char,Maennchen:Int) : Boolean = false
  def throwDicec : String = "1"
  def Runde(player:Array[Char],Maennchen:Int):Unit = {}
}
