package de.htwg.se.madn
package model

import scala.collection.View.Single

final case class Home(inserts: Array[Option[String]]) extends Strategy {
  val figuren = inserts

  override def toString: String = {

    var s = "|"
    inserts.foreach(ins => {
      if (ins == None) {
        s = s + "    |"
      } else {
        s = s + " " + ins + " |"
      }
    })

    val box =
      ("+") + ("----+" * inserts.length) + "\n" + s + "\n" + ("+") + ("----+" * inserts.length) + "\n"
    box
  }
    override def move(Figur: String,Anzahl: Int): Option[String] = {
      var aktuell = figuren.indexOf(Figur)
      if (aktuell== -1){
        "-1"
      }else{
        figuren(aktuell) = None//null wird noch ersetzt
        if(figuren(aktuell+Anzahl)!= None){
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
