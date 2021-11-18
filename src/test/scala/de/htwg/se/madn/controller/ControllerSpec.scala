package de.htwg.se.madn
package Controller

import model.{Player, Field, Home}
import util.{Observer,Observable}
//import Controller.Controller
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class ControllerSpec extends AnyWordSpec with Matchers:
  "A Controller" when {
    "observed by an Observer" should {
          var z: Array[String] = new Array[String](2)
          val field = new Field(2,z)
          val home = new Home(z)
          val player = new Player(z)
          val controller = new Controller(home,player,field)
          val obs = new Obs()
          controller.add(obs)
          "notify its Observer after a new game" in {
            controller.newGame(z,z,z)
            obs.updated should be(true)
            controller.player.toString.count(_ == '+') should equal(6)
            controller.home.toString.count(_ == '+') should equal(6)
            controller.field.toString.count(_ == '+') should equal(6)
          }
        }
  }
  case class Obs() extends Observer:
    var updated = false
    override def update: Unit = updated = true 