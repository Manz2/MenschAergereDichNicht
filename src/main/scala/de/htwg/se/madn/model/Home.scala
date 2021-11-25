package de.htwg.se.madn
package model

final case class Home(inserts: Array[String]) extends Strategy {
  val figuren = inserts

  override def toString: String = {

    var s = "|"
    inserts.foreach(ins => {
      if (ins == null) {
        s = s + "    |"
      } else {
        s = s + " " + ins + " |"
      }
    })

    val box =
      ("+") + ("----+" * inserts.length) + "\n" + s + "\n" + ("+") + ("----+" * inserts.length) + "\n"
    box
  }
  override def move(Figur:String,Anzahl:Int):String ={
      var aktuell = figuren.indexOf(Figur)
      if (aktuell== -1){
        "-1"
      }else{
        figuren(aktuell) = null//null wird noch ersetzt
        if(figuren(aktuell+Anzahl)!= null){
          figuren(aktuell+Anzahl)=Figur
          Figur
        } else{
          var alt = figuren(aktuell+Anzahl)
          figuren(aktuell+Anzahl)=Figur
          alt
        }
      }
  }
}
