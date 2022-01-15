package de.htwg.se.madn

import aview.{Tui}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import model.PlayerComponent.PlayerInterface
import model.PlayerComponent.PlayerBaseImpl._
import model.HomeComponent.HomeInterface
import model.HomeComponent.HomeBaseImpl._
import model.FieldComponent.FieldInterface
import model.FieldComponent.fieldBaseImpl._
import scala.util.{Try,Success,Failure}
import util.Observer
import Controller.controllerComponent.ControllerInterface
import Controller.controllerComponent.controllerBaseImpl._

class TuiSpec extends AnyWordSpec with Matchers {

    "A Tui" should {
        "create an new madn Game with 1 player on input 'n1'" in {
            var inserts: Array[Option[String]] = new Array[Option[String]](10)
            val ho = new Home()
            val fi = new Field()
            val pl = new Player() 
            val co = new Controller()
            val tui = new Tui(co)
            tui.processInputLine("n1")
            co.player.toString.count(_ == '+') should equal(10)
            co.home.toString.count(_ == '+') should equal(10)
            co.field.toString.count(_ == '+') should equal(42)
        }
        "create an new madn Game with s players on input 'n2'" in {
            var inserts: Array[Option[String]] = new Array[Option[String]](10)
            val ho = new Home()
            val fi = new Field()
            val pl = new Player() 
            val co = new Controller()
            val tui = new Tui(co)
            tui.processInputLine("n2")
            co.player.toString.count(_ == '+') should equal(18)
            co.home.toString.count(_ == '+') should equal(18)
            co.field.toString.count(_ == '+') should equal(42)
        }
        "create an new madn Game with 3 players on input 'n3'" in {
            var inserts: Array[Option[String]] = new Array[Option[String]](10)
            val ho = new Home()
            val fi = new Field()
            val pl = new Player() 
            val co = new Controller()
            val tui = new Tui(co)
            tui.processInputLine("n3")
            co.player.toString.count(_ == '+') should equal(26)
            co.home.toString.count(_ == '+') should equal(26)
            co.field.toString.count(_ == '+') should equal(42)
        }
        "create an new madn Game with 4 players on input 'n4'" in {
            var inserts: Array[Option[String]] = new Array[Option[String]](10)
            val ho = new Home()
            val fi = new Field()
            val pl = new Player() 
            val co = new Controller()
            val tui = new Tui(co)
            tui.processInputLine("n4")
            co.player.toString.count(_ == '+') should equal(34)
            co.home.toString.count(_ == '+') should equal(34)
            co.field.toString.count(_ == '+') should equal(42)
        }
        "start a new round with player a's turn on input 'a'" in {
            val co = new Controller()
            val tui = new Tui(co)
            tui.processInputLine("a")
            tui.turn should equal('a')
            tui.diceVal.toInt should be <= 6
        }
        "start a new round with player b's turn on input 'b'" in {
            val co = new Controller()
            val tui = new Tui(co)
            tui.processInputLine("b")
            tui.turn should equal('b')
            tui.diceVal.toInt should be <= 6
        }
        "start a new round with player c's turn on input 'c'" in {
            val co = new Controller()
            val tui = new Tui(co)
            tui.processInputLine("c")
            tui.turn should equal('c')
            tui.diceVal.toInt should be <= 6
        }
        "start a new round with player d's turn on input 'd'" in {
            val co = new Controller()
            val tui = new Tui(co)
            tui.processInputLine("d")
            tui.turn should equal('d')
            tui.diceVal.toInt should be <= 6
        }
        "move figure 1 on input '1'" in {
            val co = new Controller()
            val tui = new Tui(co)
            tui.startGame(1)
            co.move(1,'A',6) should equal("noch einer Raus")
        }
        "move figure 2 on input '2'" in {
            val co = new Controller()
            val tui = new Tui(co)
            tui.startGame(1)
            co.move(2,'A',6) should equal("noch einer Raus")
        }
        "move figure 2 on input '3'" in {
            val co = new Controller()
            val tui = new Tui(co)
            tui.startGame(1)
            co.move(3,'A',6) should equal("noch einer Raus")
        }
        "move figure 2 on input '4'" in {
            val co = new Controller()
            val tui = new Tui(co)
            tui.startGame(1)
            co.move(4,'A',6) should equal("noch einer Raus")
        }
    }
}

