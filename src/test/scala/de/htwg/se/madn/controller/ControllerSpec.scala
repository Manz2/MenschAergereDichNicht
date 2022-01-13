package de.htwg.se.madn
package Controller

import util.{Observer,Observable}
//import Controller.Controller
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

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

class ControllerSpec extends AnyWordSpec with Matchers:
  "A Controller" when {
    "observed by an Observer" should {
          var z: Array[Option[String]] = new Array[Option[String]](2)
          var count1 = 0
          z.foreach(ins => {
          z(count1) = None: Option[String]
          count1 = count1 + 1
          })
          val field = new Field(z)
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