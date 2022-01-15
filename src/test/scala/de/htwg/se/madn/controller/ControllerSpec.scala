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
import de.htwg.se.madn.Controller.controllerComponent.ControllerInterface
import de.htwg.se.madn.Controller.controllerComponent.controllerBaseImpl._

class ControllerSpec extends AnyWordSpec with Matchers:
  "A Controller" when {
    "observed by an Observer" should {
          var z: Array[Option[String]] = new Array[Option[String]](2)
          var count1 = 0
          z.foreach(ins => {
          z(count1) = None: Option[String]
          count1 = count1 + 1
          })
          /*val field = new Field(z)
          val home = new Home(z)
          val player = new Player(z)*/
          val controller = new Controller()
          val obs = new Obs()
          controller.add(obs)
          "notify its Observer after a new game" in {
            controller.newGame(z,z,z)
            obs.updated should be(true)
            controller.player.toString.count(_ == '+') should equal(6)
            controller.home.toString.count(_ == '+') should equal(6)
            controller.field.toString.count(_ == '+') should equal(6)
          }
          "move a figure" in{
            controller.newGame(z,z,z)
            var x: Array[Option[String]] = Array(Some("A1"),Some("A2"),None,Some("B2"),Some("B3"))
            controller.field.figuren = x
            controller.domove(Some("A1"),2)
            controller.field.figuren(2) should equal(Some("A1"))
            obs.updated should be(true)
          }
          "undo a step" in {
            controller.newGame(z,z,z)
            var x: Array[Option[String]] = Array(Some("A1"),Some("A2"),None,Some("B2"),Some("B3"))
            controller.field.figuren = x
            controller.domove(Some("A1"),2)
            controller.undo
            controller.field.figuren(0) should equal(Some("A1"))
            obs.updated should be(true)
          }
          "redo a step" in {
            controller.newGame(z,z,z)
            var x: Array[Option[String]] = Array(Some("A1"),Some("A2"),None,Some("B2"),Some("B3"))
            controller.field.figuren = x
            controller.domove(Some("A1"),2)
            controller.undo
            controller.field.figuren(0) should equal(Some("A1"))
            controller.redo
            controller.field.figuren(2) should equal(Some("A1"))
            obs.updated should be(true)
          }
          "check the player field" in{
            controller.newGame(z,z,z)
              var x: Array[Option[String]] = Array(Some("A1"),Some("A2"),Some("A3"),Some("A4"))
              controller.player.figuren = x
              controller.nochAlle('A') should equal(true)
              x = Array(Some("A1"),Some("A2"),Some("A3"),None)
              controller.player.figuren = x
              controller.nochAlle('A') should equal(false)
          }
          "throw the dice" in {
            controller.throwDicec.toInt should be <=6
          }
          "try 3 times to leave the player field" in {
            controller.newGame(z,z,z)
            var x: Array[Option[String]] = Array(Some("A1"),Some("A2"),Some("A3"),Some("A4"))
            controller.player.figuren = x
            controller.Alleda('A').length should be > 5;
            
          }
          "move a figure out if the dice shows 6" in{
            controller.newGame(z,z,z)
            var x: Array[Option[String]] = Array(Some("A1"),Some("A2"),Some("A3"),Some("A4"))
            controller.player.figuren = x
            var a = controller.Alleda('A')
            while(!a.equals("du hast es raus geschafft\n")){
              a = controller.Alleda('A')
            }
            controller.field.figuren(0) should equal(Some("A1"))
          }

          "send a figure back to the playerfield" in {
              
          }
        }
  }
  case class Obs() extends Observer:
    var updated = false
    override def update: Unit = updated = true 