package de.htwg.se.madn
package fileIoComponent.fileIoJsonImpl

import com.google.inject.name.Names
import com.google.inject.{Guice, Inject}
import net.codingwell.scalaguice.InjectorExtensions._
import de.htwg.se.madn.madnModule

import FieldComponent.FieldInterface
import FieldComponent.fieldBaseImpl.Field
import de.htwg.se.madn.model.fileIoComponent.FileIOInterface
import play.api.libs.json._
import scala.io.Source
import play.api.libs.json._
import java.io.{File,PrintWriter}
import scala.io.Source


class fileIoJsonImpl extends FileIOInterface{
    def save(json:JsValue): Unit= {
        val pw = PrintWriter(File("game.json"))
        pw.write(Json.prettyPrint(json))
        pw.close
    }
    def load(): JsValue ={
        val source: String = Source.fromFile("game.json").getLines.mkString
        Json.parse(source)
    }
}
