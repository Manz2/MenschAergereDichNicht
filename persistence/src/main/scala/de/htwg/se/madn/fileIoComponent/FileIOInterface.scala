package de.htwg.se.madn
package model.fileIoComponent
import play.api.libs.json._
import java.io.{File,PrintWriter}
import scala.io.Source

trait FileIOInterface {
  def save(json:JsValue): Unit
  def load(): JsValue
}
