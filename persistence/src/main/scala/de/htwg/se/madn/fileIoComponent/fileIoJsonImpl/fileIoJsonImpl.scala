package de.htwg.se.madn
package fileIoComponent.fileIoJsonImpl

import com.google.inject.name.Names
import com.google.inject.{Guice, Inject}
import net.codingwell.scalaguice.InjectorExtensions._

import de.htwg.se.madn.model.fileIoComponent.FileIOInterface
import de.htwg.se.madn.databaseComponent._
import play.api.libs.json._
import scala.io.Source
import play.api.libs.json._
import java.io.{File,PrintWriter}
import scala.io.Source


object fileIoJsonImpl{
    def save(json:String): Unit= {
        println("[SAVE fileiojson]\t" + json)
        //DBImpl.saveGame(json)

        MongodbImpl.saveAllFields(json)

        //val pw = PrintWriter(File("game.json"))
        //pw.write(json)
        //pw.close
    }
    def load(): String ={
        val source: String = Source.fromFile("game.json").getLines.mkString
        //source
        //DBImpl.loadGame().toString
        MongodbImpl.loadAllFields.toString
    }
}
