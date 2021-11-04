package Documents.Htwg.se.MADN.MenschAergereDichNicht

final case class Home(size: Int, inserts: Array[String]) {

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
      ("+") + ("----+" * size) + "\n" + s + "\n" + ("+") + ("----+" * size) + "\n"
    box
  }
}
