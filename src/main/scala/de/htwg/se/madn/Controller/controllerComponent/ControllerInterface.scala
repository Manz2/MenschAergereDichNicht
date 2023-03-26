package de.htwg.se.madn
package Controller.controllerComponent

import util.Observable
import util.UndoManager
import scala.util.{Try,Success,Failure}
import scala.util.Random
import scala.util.control.Breaks._
import model.FigureComponent.FigureBaseImpl.Figure

//trait ControllerInterface(val Home:HomeInterface,val Field:FieldInterface,val Player:PlayerInterface) extends Observable{
trait ControllerInterface() extends Observable{
  def newGame(nPlayer:Int) : Unit
  /*
  def domove(figur:Figure,anzahlFelder:Int): Unit 
  def undo: Unit 
  def redo: Unit 
  def save: Unit
  def load: Unit
  def nochAlle(spieler:Char) : Boolean 
  def throwDicec : String
  def Alleda(spieler:Char): String
  def move(figur:Figure,dicev:Int):String
  def backHome(i:Int):Unit
  def reachedEnd(figur:Figure,dicev:Int):Unit
  def raus(figur:Figure,spieler:Char):String
  */
}
