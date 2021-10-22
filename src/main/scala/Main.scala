object Madn {
  @main def hello: Unit =
    println("")
  print(field());

//Anzahl Spielfelder
  val eol = sys.props("line.separator")
  def field(length: Int = 20) =
    ("+") + ("----+" * length) + eol + ("|") + ("    |" * length) + eol + ("+") + ("----+" * length) + eol

  //Anzahl Spieler
  def players(player: Int = 20, figures: Int = 2) =
    ("+") + ("----+" * player * figures) + eol + ("|") + ("    |" * player * figures) + eol + ("+") + ("----+" * player * figures) + eol

  //Ziel
  def home(player: Int = 20, figures: Int = 2) =
    ("+") + ("----+" * player * figures) + eol + ("|") + ("    |" * player * figures) + eol + ("+") + ("----+" * player * figures) + eol

}
