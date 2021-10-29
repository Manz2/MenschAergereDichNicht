package Htwg.se.MADN.MenschAergereDichNicht.model

object Madn {
  @main def hello: Unit =
    println("")
  print(field())
  print(players())
  print(home())

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