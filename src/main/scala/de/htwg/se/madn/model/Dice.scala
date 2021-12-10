package de.htwg.se.madn
package model

import scala.util.Random

class Dice {
  val r = scala.util.Random
    val e = r.nextInt(6)+1  
//override def toString = e.toString
}
