package de.htwg.se.madn
package model.FieldComponent.fieldMockImpl
import model.FieldComponent.FieldInterface
import model.FieldComponent.fieldBaseImpl.Strategy


class field() extends Strategy with FieldInterface {
  var x: Array[Option[String]] = new Array[Option[String]](10)
      var count1 = 0
      x.foreach(ins => {
      x(count1) = None: Option[String]
      count1 = count1 + 1
      })
  var figuren = x
  def move(Figur:Option[String],Anzahl:Int): Option[String] = Some("-1")
}
