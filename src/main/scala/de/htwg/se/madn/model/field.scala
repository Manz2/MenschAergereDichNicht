package de.htwg.se.madn
package model

final case class Field(positions: Array[String]) extends Strategy {
  val figuren = positions

  override def toString: String = {

    var s = "|"
    positions.foreach(ins => {
      if (ins == null) {
        s = s + "    |"
      } else {
        s = s + " " + ins + " |"
      }
    })

    val box =
      ("+") + ("----+" * positions.length) + "\n" + s + "\n" + ("+") + ("----+" * positions.length) + "\n"
    box
  }
  override def move(Figur:String,Anzahl:Int):String ={
      var aktuell = figuren.indexOf(Figur)
      if (aktuell== -1){
        "-1"
      }else{
        figuren(aktuell) = null//null wird noch ersetzt
        if(figuren(aktuell+Anzahl)!= null){
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
