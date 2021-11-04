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
    var insertsVector = inserts.toVector
    var player = new Player(insertsVector)
    print(player)
    //Field
    var z: Array[String] = new Array[String](Felderanz)
    var filed = new Field(Felderanz, z)
    print(filed)

    //home
    var h: Array[String] = new Array[String](insertsVector.length)
    var homes = new Field(insertsVector.length, h)
    println(homes)

    //Anzahl Spielfelder
    def field(length: Int = 1) =
      ("+") + ("----+" * length) + "\n" + ("|") + ("    |" * length) + "\n" + ("+") + ("----+" * length) + "\n"

    //Anzahl Spieler
    def players(player: Int = 1, figures: Int = 1) =
      ("+") + ("----+" * player * figures) + "\n" + ("|") + ("    |" * player * figures) + "\n" + ("+") + ("----+" * player * figures) + "\n"

    //Ziel
    def home(player: Int = 1, figures: Int = 1) =
      ("+") + ("----+" * player * figures) + "\n" + ("|") + ("    |" * player * figures) + "\n" + ("+") + ("----+" * player * figures) + "\n"
  }
}
