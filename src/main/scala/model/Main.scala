package Documents.Htwg.se.MADN.MenschAergereDichNicht
import Documents.Htwg.se.MADN.MenschAergereDichNicht.{Player, Field, Home}
import scala.io.StdIn.readLine

object Madn {
  @main def main: Unit = {
    print("Pro Spieler einen Buchstaben (mit Leertaste trennen): ")
    var Spieler = readLine()
    val SpielerChar = Spieler.toCharArray
    println("")
    print("Anzahl Figuren pro Spieler: ")
    var anzFig = readLine()
    println("")
    print("Anzahl Spielfelder: ")
    var Felderanz = readLine().toInt
    println("")

    //Player
    val inserts = scala.collection.mutable.ArrayBuffer.empty[String]
    for (a <- SpielerChar) {
      if (a != ' ') {
        for (b <- 1 until anzFig.toInt + 1) {
          val d = a.toString + b.toString
          inserts += d
        }
      }
    }
    var insertsArray = inserts.toArray
    var player = new Player(insertsArray)
    print(player)
    //Field
    var z: Array[String] = new Array[String](Felderanz)
    var filed = new Field(Felderanz, z)
    print(filed)

    //home
    var h: Array[String] = new Array[String](insertsArray.length)
    var homes = new Field(insertsArray.length, h)
    println(homes)
  }
}
