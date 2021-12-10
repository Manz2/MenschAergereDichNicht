package de.htwg.se.madn
package model
/*Factory pattern*/
import scala.util.{Try,Success,Failure}

trait Dice {
    def throwTheDice(dice : Int): Try[Int]
}

private class Seis extends Dice {
 override def throwTheDice(dice: Int): Try[Int] = {
   if dice != 6 then return Failure(NoValidThrowException("Fehler"));
   else return Success(dice)
 }
}

private class Diez extends Dice {
 override def throwTheDice(dice : Int): Try[Int] = {
   if dice != 10 then return Failure(NoValidThrowException("Fehler"));
   else return Success(dice)
 }
}

object Dice {
 def apply(kind: String) = kind match {
   case "six" => new Seis()
   case "ten" => new Diez()
 }
}

case class NoValidThrowException(message: String) extends Exception(message)
