package de.htwg.se.madn
package databaseComponent

trait DBInterface {
  def loadAllFields:String
  def saveAllFields(json:String):Unit
}
