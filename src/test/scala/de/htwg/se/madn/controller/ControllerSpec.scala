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
          "move a figure an do a step" in{
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
          "save the game" in {
            var t: Array[Option[String]] = new Array[Option[String]](2)
                val controller = new Controller()
                controller.newGame(t,t,t)
                var x: Array[Option[String]] = new Array[Option[String]](20)
                var count1 = 0
                x.foreach(ins => {
                x(count1) = None: Option[String]
                count1 = count1 + 1
                })
                controller.field.figuren = x

                var y: Array[Option[String]] = Array(Some("A1"),Some("A2"),Some("A3"),Some("A4"))

                controller.player.figuren = y

                var z: Array[Option[String]] = new Array[Option[String]](4)
                var count2 = 0
                z.foreach(ins => {
                z(count2) = None: Option[String]
                count2 = count2 + 1
                })
                controller.home.figuren = z
                controller.save
                controller.newGame(t,t,t)
                controller.load

                controller.player.figuren should contain inOrder (Some("A1"),Some("A2"),Some("A3"),Some("A4"))
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
            controller.newGame(z,z,z)

            var x: Array[Option[String]] = new Array[Option[String]](16)
            var count1 = 0
            x.foreach(ins => {
              x(count1) = None: Option[String]
              count1 = count1 + 1
            })

            var y: Array[Option[String]] = Array(Some("A1"),Some("B1"),Some("C1"),Some("D1"),None)

            controller.player.figuren = x
            controller.field.figuren = y
            controller.backHome(0)
            controller.backHome(1)
            controller.backHome(2)
            controller.backHome(3)

            controller.field.figuren should contain only(None)
            controller.player.figuren should contain inOrder (Some("A1"),Some("B1"),Some("C1"),Some("D1"),None)
          }

          "move a figure" in {
            controller.newGame(z,z,z)

            var x: Array[Option[String]] = new Array[Option[String]](20)
            var count1 = 0
            x.foreach(ins => {
              x(count1) = None: Option[String]
              count1 = count1 + 1
            })

            var w: Array[Option[String]] = new Array[Option[String]](16)
            var count2 = 0
            w.foreach(ins => {
              w(count2) = None: Option[String]
              count2 = count2 + 1
            })


            var y: Array[Option[String]] = Array(None,Some("A2"),Some("A3"),Some("A4"))
            controller.field.figuren = x
            controller.field.figuren(2) = Some("A1")
            controller.field.figuren(1) = Some("B2")
            controller.field.figuren(5) = Some("B1")
            controller.field.figuren(10) = Some("C1")
            controller.field.figuren(15) = Some("D1")
            controller.player.figuren = y
            controller.home.figuren = w


            controller.move(1,'x',3) should equal("X1 ist nicht im Feld waehle eine andere Figur")

            //Tests for player a
            controller.move(1,'a',6)
            controller.field.figuren(0) should equal(Some("A2"))

            controller.move(2,'a',4)
            controller.field.figuren(4) should equal(Some("A2"))

            controller.move(2,'a',18)
            controller.home.figuren(1) should equal(Some("A2"))

            controller.move(2,'b',1)
            controller.player.figuren(0) should equal(Some("A1"))

            //Test for player b,c,d
            controller.move(1,'b',15)
            controller.field.figuren(0) should equal(Some("B1"))

            controller.move(1,'b',15)
            controller.home.figuren(4) should equal(Some("B1"))

            controller.move(1,'c',10)
            controller.field.figuren(0) should equal(Some("C1"))

            controller.move(1,'c',15)
            controller.home.figuren(8) should equal(Some("C1"))

            controller.move(1,'d',5)
            controller.field.figuren(0) should equal(Some("D1"))

            controller.move(1,'d',18)
            controller.home.figuren(12) should equal(Some("D1"))
          }
          "end the Game" in{
            controller.newGame(z,z,z)

            var x: Array[Option[String]] = new Array[Option[String]](20)
            var count1 = 0
            x.foreach(ins => {
              x(count1) = None: Option[String]
              count1 = count1 + 1
            })
            controller.field.figuren = x

            var y: Array[Option[String]] = Array(Some("A1"),Some("A2"),Some("A3"),None)

            controller.home.figuren = y

            controller.field.figuren(18) = Some("A4")

            controller.move(4,'a',5) should equal ("Spieler A hat gewonnen")

          }
          "leave the player field with the next figure" in {
            controller.newGame(z,z,z)

            var x: Array[Option[String]] = new Array[Option[String]](20)
            var count1 = 0
            x.foreach(ins => {
              x(count1) = None: Option[String]
              count1 = count1 + 1
            })

            var y: Array[Option[String]] = new Array[Option[String]](16)
            var count2 = 0
            y.foreach(ins => {
              y(count2) = None: Option[String]
              count2 = count2 + 1
            })

            controller.field.figuren = x
            controller.player.figuren = y
            controller.field.figuren(0) = Some("B2")
            controller.field.figuren(5) = Some("C2")
            controller.field.figuren(10) = Some("D2")
            controller.field.figuren(15) = Some("A2")
            controller.raus(Some("A1"),'A')
            controller.raus(Some("B1"),'B')
            controller.raus(Some("C1"),'C')
            controller.raus(Some("D1"),'D')

            controller.field.figuren should contain inOrder (Some("A1"),Some("B1"),Some("C1"),Some("D1"),None)
          }
        }
  }
  case class Obs() extends Observer:
    var updated = false
    override def update: Unit = updated = true 