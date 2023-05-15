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
        FieldDAO.create

        val pw = PrintWriter(File("game.json"))
        pw.write(json)
        pw.close
    }
    def load(): String ={
      //FieldDAO.create
      //PlayerDAO.create
      //FigureDAO.create
      //IndexDAO.create
        FieldDAO.update("player")
        PlayerDAO.update("A")
        FigureDAO.update(1,"A")
        IndexDAO.update(123,"player",456)


        val source: String = Source.fromFile("game.json").getLines.mkString
        source
    }
}
