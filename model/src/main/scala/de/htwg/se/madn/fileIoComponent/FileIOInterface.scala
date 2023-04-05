package de.htwg.se.madn
package model.fileIoComponent

import FieldComponent.FieldInterface
import FieldComponent.fieldBaseImpl.Field

trait FileIOInterface {
  def loadPlayer: FieldInterface
  def loadField: FieldInterface
  def loadHome: FieldInterface

  def save(player:FieldInterface,filed:FieldInterface,home:FieldInterface): Unit

}
