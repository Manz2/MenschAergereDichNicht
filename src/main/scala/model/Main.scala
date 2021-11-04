package Documents.Htwg.se.MADN.MenschAergereDichNicht
import Documents.Htwg.se.MADN.MenschAergereDichNicht.{Player}

object Madn {
  @main def hello: Unit =
    println("")

  print(field(20))
  var numPlay = 8
  val inserts = Vector("A1", null, "A3", "A4", "B1", "B2", "B3", "B4")
  var player = new Player(numPlay, inserts)
  print(player)
  print(home(4, 2))
  print("\n")

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
