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

    var s = "|"
    figuren.foreach(ins => {
      if (ins.equals(None)) {
        s = s + "    |"
      } else {
        s = s + " " + ins.get + " |"
      }
    })

    val box =
      ("+") + ("----+" * figuren.length) + "\n" + s + "\n" + ("+") + ("----+" * figuren.length) + "\n"
    box
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
