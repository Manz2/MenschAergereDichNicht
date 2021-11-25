package de.htwg.se.madn
package model
/*Builder pattern*/
import scala.compiletime.ops.boolean

abstract class DiceBuilder{
    var augen = Int
    var fair = Boolean

    def fairDice(fair:boolean):DiceBuilder
    def Numeyes(eyes:Int):DiceBuilder

    //def build:dice
}
class fairDice(builder:DiceBuilder){
    val augen = builder.augen
    val r = scala.util.Random

    def rollTheDice = r.nextInt(augen)
}
var random = new DiceBuilder.fairDice(true).Numeyes(6)