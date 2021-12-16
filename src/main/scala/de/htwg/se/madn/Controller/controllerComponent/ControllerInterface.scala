package de.htwg.se.madn
package Controller.controllerComponent

import util.Observable
import util.UndoManager
import scala.util.{Try,Success,Failure}
import scala.util.Random
import scala.util.control.Breaks._

trait ControllerInterface extends Observable{
  def newGame(inserts: Array[Option[String]],fieldpositions: Array[Option[String]],homepositions: Array[Option[String]]) : Unit
  def domove(Figur:Option[String],Anzahl:Int): Unit 
  def undo: Unit 
  def redo: Unit 
  def nochAlle(spieler:Char,Maennchen:Int) : Boolean 
  def throwDicec : String
  def Runde(player:Array[Char],Maennchen:Int):Unit
}
