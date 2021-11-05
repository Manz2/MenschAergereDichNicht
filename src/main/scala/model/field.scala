package Documents.Htwg.se.MADN.MenschAergereDichNicht.model

final case class Field(size: Int, positions: Array[String]) {

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
      ("+") + ("----+" * size) + "\n" + s + "\n" + ("+") + ("----+" * size) + "\n"
    box
  }
}
