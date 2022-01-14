package de.htwg.se.madn
package model.HomeComponent.HomeMockImpl
import model.HomeComponent.HomeInterface
import model.FieldComponent.fieldBaseImpl.Strategy
class field(positions: Array[Option[String]]) extends Strategy with HomeInterface {
  var x: Array[Option[String]] = new Array[Option[String]](10)
      var count1 = 0
      x.foreach(ins => {
      x(count1) = None: Option[String]
      count1 = count1 + 1
      })

  var figuren = x
  def move(Figur:Option[String],Anzahl:Int): Option[String] = Some("-1")
}

