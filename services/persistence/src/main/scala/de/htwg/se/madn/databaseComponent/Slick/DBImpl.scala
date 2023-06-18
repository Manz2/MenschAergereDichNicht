package de.htwg.se.madn
package databaseComponent

import de.htwg.se.madn.databaseComponent._
import play.api.libs.json._
import scala.io.Source
import play.api.libs.json._
import scala.concurrent.Await
import scala.concurrent.duration._

object DBImpl {
    def saveGame(value:String):Unit = {
        val jsString: JsValue = Json.parse(value)

        FieldDAO.create
        IndexDAO.create
        PlayerDAO.create
        FigureDAO.create

        FieldDAO.delete
        IndexDAO.delete
        PlayerDAO.delete
        FigureDAO.delete

        FieldDAO.update("Field")
        FieldDAO.update("Player")
        FieldDAO.update("Home")

        val field_ = (jsString \ "Field").as[List[String]]

        var counter = 0
        field_.foreach(e => {
            IndexDAO.update(e,"Field",counter)
            counter+=1
        })
        counter = 0
        val fieldPlayer_ = (jsString \ "Player").as[List[String]]
        fieldPlayer_.foreach(e => {
            IndexDAO.update(e,"Player",counter)
            counter+=1
        })
        counter = 0
        val fieldHome_ = (jsString \ "Home").as[List[String]]
        fieldHome_.foreach(e => {
            IndexDAO.update(e,"Home",counter)
            counter+=1
        })
    }
    def loadGame():JsValue = {
        Await.result(IndexDAO.read,10.seconds)
    }
  
}