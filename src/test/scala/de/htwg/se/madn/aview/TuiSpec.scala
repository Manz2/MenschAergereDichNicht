package de.htwg.se.madn

import aview.{Tui}
import model.{Player, Field, Home}
import util.{Observer,Observable}
import Controller.Controller
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class TuiSpec extends AnyWordSpec with Matchers {

    "A Tui" should {
        /*"run schould read correctly" in {
            val in = new ByteArrayInputStream("abc".getBytes)
            System.setIn(in)
            StdIn.readLine() === "abc"
        }*/
        "create an empty madn Game on input 'A B 2 2'" in {
            var inserts: Array[String] = new Array[String](10)
            val ho = new Home(inserts: Array[String])
            val fi = new Field(inserts: Array[String])
            val pl = new Player(inserts: Array[String]) 
            val co = new Controller(ho, pl, fi)
            val tui = new Tui(co)
            tui.printplayer("A B","2","2")
            co.player.toString.count(_ == '+') should equal(10)
            co.home.toString.count(_ == '+') should equal(10)
            co.field.toString.count(_ == '+') should equal(6)
        }
    }
}

