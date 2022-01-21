package de.htwg.se.madn
package model.fileIoComponent

import model.PlayerComponent.PlayerInterface
import model.PlayerComponent.PlayerBaseImpl.Player
import model.HomeComponent.HomeInterface
import model.HomeComponent.HomeBaseImpl.Home
import model.FieldComponent.FieldInterface
import model.FieldComponent.fieldBaseImpl.Field

trait FileIOInterface {
  def loadPlayer: PlayerInterface
  def loadField: FieldInterface
  def loadHome: HomeInterface

  def save(player:PlayerInterface,filed:FieldInterface,home:HomeInterface): Unit

}
