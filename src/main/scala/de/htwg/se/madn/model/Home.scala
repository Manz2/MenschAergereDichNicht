package de.htwg.se.madn
package model

import scala.collection.View.Single

final case class Home(inserts: Array[String]) extends Strategy {
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
<<<<<<< HEAD
    override def move(Figur: String,Anzahl: Int): String = {
=======
    override def move(Figur: String,Anzahl: Int): Option[String] = {
>>>>>>> 09b8f85ee8e53211dfbcaba76cafcaa9d29d9e37
      var aktuell = figuren.indexOf(Figur)
      if (aktuell== -1){
        "-1"
      }else{
        figuren(aktuell) = null//null wird noch ersetzt
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
