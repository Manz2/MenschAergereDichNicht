package de.htwg.se.madn
package model

final case class Field(positions: Array[Option[String]]) extends Strategy {
  val figuren = positions

  override def toString: String = {

    var s = "|"
    positions.foreach(ins => {
      if (ins.isEmpty) {
        s = s + "    |"
      } else {
        s = s + " " + ins + " |"
      }
    })

    val box =
      ("+") + ("----+" * positions.length) + "\n" + s + "\n" + ("+") + ("----+" * positions.length) + "\n"
    box
  }

  def move(Figur:Option[String],Anzahl:Int): Option[String] = {
    var aktuell = figuren.indexOf(Figur)
    if (aktuell== -1){
      Some("-1")
    }else{
      figuren(aktuell) = None//null wird noch ersetzt
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
