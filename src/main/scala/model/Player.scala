package Documents.Htwg.se.MADN.MenschAergereDichNicht

final case class Player(inserts: Vector[String]) {

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
