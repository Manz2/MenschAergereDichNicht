object Madn {
  @main def hello: Unit =
    println("")

//Anzahl Spielfelder

  var länge = 20
  print("+")
  println("----+" * länge)
  print("|")
  println("    |" * länge)
  print("+")
  println("----+" * länge)

  //Anzahl Spieler
  var spieler = 1
  var figuren = 4
  print("+")
  println("----+" * spieler * figuren)
  print("|")
  println("    |" * spieler * figuren)
  print("+")
  println("----+" * spieler * figuren)

  //Ziel
  print("+")
  println("----+" * spieler * figuren)
  print("|")
  println("    |" * spieler * figuren)
  print("+")
  println("----+" * spieler * figuren)
}
