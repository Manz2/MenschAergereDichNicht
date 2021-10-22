object Madn {
  @main def hello: Unit =
    println("Hello world!")
  println(msg)

//Anzahl Spielfelder

  var x = 0
  var länge = 20
  print("""
  +
  |
  +
  
  """)

  while (x < länge) {
    print("""
    ----+
        |
    ----+
    """)
    x = x + 1;
  }
  println();

//Anzahl Spieler
  var spieler = 1
  var figuren = 1
  x = 0;
  var y = 0;

  while (x < spieler * 4) {
    print("""
    +
    |
    +
    """)
    while (y < figuren) {
      print("""
    +----+
         |
    +----+
    """)
    }
    println()
  }
}
