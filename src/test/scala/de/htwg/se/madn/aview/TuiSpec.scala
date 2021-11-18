package de.htwg.se.madn

import aview.{Tui}
import model.{Player, Field, Home}
import util.{Observer,Observable}
import Controller.Controller
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class TuiSpec extends AnyWordSpec with Matchers {

    "A Tui" should {
        "have arguments" in {
            var inserts: Array[String] = new Array[String](10)
            val ho = new Home(inserts: Array[String])
            val fi = new Field(1, inserts: Array[String])
            val pl = new Player(inserts: Array[String]) 
            val co = new Controller(ho, pl, fi)
            val tui = new Tui(co)
            var Spieler = "abc"
            var anzFig = "4"
            var Felderanz = "8"

            Spieler should fullyMatch regex """[A-Za-z]+"""
            anzFig should fullyMatch regex """[1-4]{1}"""
            Felderanz should fullyMatch regex """[1-9]"""
        }
        "create a new game  array on input 'A B 2 2'" in {
        var z: Array[String] = new Array[String](2)
        val smallfield = new Field(2,z)
        val smallHomefield = new Home(z)
        val smallPlayerfield = new Player(z)
        val controller = new Controller(smallHomefield,smallPlayerfield,smallfield)
        val tui = new Tui(controller)
        //tui.run should be(new Controller.newGame(z,z,z))
        }
        
    }

    
  
}
