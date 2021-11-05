package Documents.Htwg.se.MADN.MenschAergereDichNicht

final case class Player(inserts: Array[String]) {

  override def toString: String = {

    var s = "|"
    inserts.foreach(ins => {
      if (ins == 0) {
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
