object Madn {
  @main def hello: Unit =
    println("")
  print(field())
  print(players())
  print(home())

  //Anzahl Spielfelder
  def field(length: Int = 10) =
    ("+") + ("----+" * length) + "\n" + ("|") + ("    |" * length) + "\n" + ("+") + ("----+" * length) + "\n"

  //Anzahl Spieler
  def players(player: Int = 1, figures: Int = 4) =
    ("+") + ("----+" * player * figures) + "\n" + ("|") + ("    |" * player * figures) + "\n" + ("+") + ("----+" * player * figures) + "\n"

  //Ziel
  def home(player: Int = 1, figures: Int = 4) =
    ("+") + ("----+" * player * figures) + "\n" + ("|") + ("    |" * player * figures) + "\n" + ("+") + ("----+" * player * figures) + "\n"

}
