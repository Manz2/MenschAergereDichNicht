package de.htwg.se.madn
package model.fileIoComponent
import play.api.libs.json._
import java.io.{File,PrintWriter}
import scala.io.Source

import FieldComponent.FieldInterface
import FieldComponent.fieldBaseImpl.Field

trait FileIOInterface {
  def save(json:JsValue): Unit
  def load(): JsValue
}
