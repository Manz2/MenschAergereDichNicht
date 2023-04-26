package de.htwg.se.madn
package fileIoComponent.fileIoJsonImpl

import com.google.inject.name.Names
import com.google.inject.{Guice, Inject}
import net.codingwell.scalaguice.InjectorExtensions._

import de.htwg.se.madn.model.fileIoComponent.FileIOInterface
import play.api.libs.json._
import scala.io.Source
import play.api.libs.json._
import java.io.{File,PrintWriter}
import scala.io.Source


object fileIoJsonImpl{
    def save(json:String): Unit= {
        val pw = PrintWriter(File("game.json"))
        pw.write(json)
        pw.close
    }
    def load(): String ={
        val source: String = Source.fromFile("game.json").getLines.mkString
        source
    }
}
