package de.htwg.se.madn
package databaseComponent

import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object MongodbImpl extends DBInterface{
  def loadAllFields:String = {
    MongodbDAO.read
  }
  def saveAllFields(json:String):Unit = {
    //MongodbDAO.delete
    val createFuture = Future {
      MongodbDAO.create
    }

    val createResult = Await.result(createFuture, Duration.Inf)
    Thread.sleep(100) 
    MongodbDAO.update(json)
  }
}
