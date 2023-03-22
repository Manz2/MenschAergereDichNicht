package de.htwg.se.madn
package model.FieldComponent.fieldBaseImpl
import model.FieldComponent.FieldInterface

final case class Field() extends Strategy with FieldInterface {
  
  var x: Array[Option[String]] = new Array[Option[String]](10)
      var count1 = 0
      x.foreach(ins => {
      x(count1) = None: Option[String]
      count1 = count1 + 1
      })
  var figuren = x

  override def toString: String = {
    def inner(value: Option[String]) : Option[String] = if (!value.equals(None)) Some(value) else Some("   ")
    def row(figuren: Array[Option[String]]): String ="|" + figuren.map(inner(_).get + " |").toString
    ("+") + ("----+" * figuren.length) + "\n" + row(figuren) + "\n" + ("+") + ("----+" * figuren.length) + "\n"
  }

  def move(Figur:Option[String],Anzahl:Int): Option[String] = {
    var aktuell = figuren.indexOf(Figur)
    if (aktuell== -1){
      Some("-1")
    }else{
      figuren(aktuell) = None
      if(!figuren(aktuell+Anzahl).isEmpty){
        var alt = figuren(aktuell+Anzahl)
        figuren(aktuell+Anzahl)=Figur
        alt
      } else{
        figuren(aktuell+Anzahl)=Figur
        Figur
      }
    }
  }
}
