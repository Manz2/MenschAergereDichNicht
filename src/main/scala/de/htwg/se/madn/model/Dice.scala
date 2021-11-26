package de.htwg.se.madn
package model
/*Factory pattern*/
import scala.util.Random

trait Dice {
    def throwTheDice: Int
}

private class Seis extends Dice {
 override def throwTheDice: Int = new Random().nextInt(6)
}

private class Diez extends Dice {
 override def throwTheDice: Int = new Random().nextInt(10)
}

object Dice {
 def apply(kind: String) = kind match {
   case "six" => new Seis()
   case "ten" => new Diez()
 }
}
