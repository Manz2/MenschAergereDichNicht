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
        /*"run schould read correctly" in {
            val in = new ByteArrayInputStream("abc".getBytes)
            System.setIn(in)
            StdIn.readLine() === "abc"
        }*/
        "create an empty madn Game on input 'n2'" in {
            var inserts: Array[Option[String]] = new Array[Option[String]](10)
            val ho = new Home(inserts: Array[Option[String]])
            val fi = new Field(inserts: Array[Option[String]])
            val pl = new Player(inserts: Array[Option[String]]) 
            val co = new Controller(ho, pl, fi)
            val tui = new Tui(co)
            tui.startGame(2)
            co.player.toString.count(_ == '+') should equal(18)
            co.home.toString.count(_ == '+') should equal(18)
            co.field.toString.count(_ == '+') should equal(42)
        }
        /*"have those inputs" in {
            var inserts: Array[String] = new Array[String](10)
            val ho = new Home(inserts: Array[String])
            val fi = new Field(inserts: Array[String])
            val pl = new Player(inserts: Array[String]) 
            val co = new Controller(ho, pl, fi)
            val tui = new Tui(co)
        }*/
    }
}

