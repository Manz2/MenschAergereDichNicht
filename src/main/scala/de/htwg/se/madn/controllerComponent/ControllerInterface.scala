package de.htwg.se.madn
package Controller.controllerComponent



import scala.util.{Try,Success,Failure}
import scala.util.Random
import scala.util.control.Breaks._
import FigureComponent.FigureBaseImpl.Figure
import FieldComponent.FieldInterface
import FigureComponent.FigureInterface

trait ControllerInterface() extends Observable{
  def newGame(nPlayer:Int) : Unit
  def domove(figur:FigureInterface ,anzahl:Int): FieldInterface 
  def undo: FieldInterface
  def redo: FieldInterface
  def save: Unit
  def load: Unit
  def raus(spieler:String):FieldInterface
  def throwDice : Int
  def nochAlle(spieler:String) : Boolean 
  def checkField(index:Int): Try[FieldInterface]
  def backHome(space:FieldInterface)(index:Int):FieldInterface
  def Alleda(spieler:String): Boolean
  def reachedHome(figur:FigureInterface):FieldInterface
  def reachedEnd(figur: FigureInterface, anzahl: Int): FieldInterface
  def move(figur:FigureInterface,anzahl:Int):FieldInterface
  def anybodyWone(thisHome:FieldInterface):Option[String]
  def getFigureFromField(player:String,nummer:Int): FigureInterface
}
