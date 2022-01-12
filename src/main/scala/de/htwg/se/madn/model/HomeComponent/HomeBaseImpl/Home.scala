package de.htwg.se.madn
package model.HomeComponent.HomeBaseImpl
import model.HomeComponent.HomeInterface
import scala.collection.View.Single

final case class Home(inserts: Array[Option[String]]) extends Strategy with HomeInterface {
  val figuren = inserts

  override def toString: String = {

    var s = "|"
    inserts.foreach(ins => {
      if (ins.equals(None)) {
        s = s + "    |"
      } else {
        s = s + " " + ins.get + " |"
      }
    })

    val box =
      ("+") + ("----+" * inserts.length) + "\n" + s + "\n" + ("+") + ("----+" * inserts.length) + "\n"
    box
  }
  def move(Figur: Option[String],Anzahl: Int): Option[String] = {
    var aktuell = figuren.indexOf(Figur)
    if (aktuell== -1){
      Some("-1")
    }else{
      figuren(aktuell) =None
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