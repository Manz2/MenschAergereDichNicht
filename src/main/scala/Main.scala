object Madn {
  @main def hello: Unit =
    println("")

//Anzahl Spielfelder
  val eol = sys.props("line.seperator")
  def feld(length: Int = 20) =
    "+" + "----+" * length + eol + "|" + "    |" * length + eol + "+" + "----+" * length + eol

  //Anzahl Spieler
  def players(player: Int = 20, figures: Int = 2) =
    ("+") + ("----+" * player * figures) + eol + ("|") + ("    |" * player * figures) + eol + ("+") + ("----+" * player * figures) + eol

  //Ziel
  def home(player: Int = 20, figures: Int = 2) =
    ("+") + ("----+" * player * figures) + eol + ("|") + ("    |" * player * figures) + eol + ("+") + ("----+" * player * figures) + eol

  print(feld);

}
