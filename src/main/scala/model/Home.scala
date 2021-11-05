package Documents.Htwg.se.MADN.MenschAergereDichNicht.model

final case class Home(inserts: Array[String]) {

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
}
