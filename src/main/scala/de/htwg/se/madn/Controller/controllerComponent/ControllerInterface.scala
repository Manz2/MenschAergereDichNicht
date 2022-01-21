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
  def save: Unit
  def load: Unit
  def nochAlle(spieler:Char) : Boolean 
  def throwDicec : String
  def Alleda(spieler:Char): String
  def move(fig:Int,pl:Char,dicev:Int):String
  def backHome(i:Int):Unit
  def reachedEnd(fig:Int,pl:Char,dicev:Int):Unit
  def raus(s:Option[String],spieler:Char):String
}
