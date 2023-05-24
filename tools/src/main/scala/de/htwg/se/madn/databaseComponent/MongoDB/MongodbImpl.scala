package de.htwg.se.madn
package databaseComponent

object MongodbImpl extends DBInterface{
  def loadAllFields:String = {
    MongodbDAO.read
  }
  def saveAllFields(json:String):Unit = {
    MongodbDAO.delete
    MongodbDAO.create
    MongodbDAO.update(json)
  }
}
