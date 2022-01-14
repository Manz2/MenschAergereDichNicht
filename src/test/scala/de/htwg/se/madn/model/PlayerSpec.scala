package de.htwg.se.madn
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

import model.PlayerComponent.PlayerInterface
import model.PlayerComponent.PlayerBaseImpl._
import model.HomeComponent.HomeInterface
import model.HomeComponent.HomeBaseImpl._
import model.FieldComponent.FieldInterface
import model.FieldComponent.fieldBaseImpl._

class PlayerSpec extends AnyWordSpec with Matchers:
  "Player" should {
    "create a small Player Filed of 2 cells" in {
      var z: Array[Option[String]] = new Array[Option[String]](2)
      var count1 = 0
      z.foreach(ins => {
      z(count1) = None: Option[String]
      count1 = count1 + 1
      })
      val player = new Player()
      player.figuren = z
      player.toString should contain only ('+', '-', '|', ' ', '\n')
      player.toString should contain allOf ('+', '-', '|', ' ', '\n')
      player.toString.count(_ == '+') should equal(6)
      player.toString.count(_ == '-') should equal(16)
      player.toString.count(_ == '|') should equal (3)
    }
    "create a bigger Player Filed of 10 cells" in {
      var x: Array[Option[String]] = new Array[Option[String]](10)
      var count1 = 0
      x.foreach(ins => {
      x(count1) = None: Option[String]
      count1 = count1 + 1
      })
      val player2 = new Player()
      player2.figuren = x
      player2.toString should contain only ('+', '-', '|', ' ', '\n')
      player2.toString should contain allOf ('+', '-', '|', ' ', '\n')
      player2.toString.count(_ == '+') should equal(22)
      player2.toString.count(_ == '-') should equal(80)
      player2.toString.count(_ == '|') should equal (11)   
    }
    "move a Figure by 10 spaces" in {
      var x: Array[Option[String]] = new Array[Option[String]](10)
      var count1 = 0
      x.foreach(ins => {
      x(count1) = None: Option[String]
      count1 = count1 + 1
      })
      val player3 = new Player()
      player3.figuren = x
      player3.move(Some("A1"),1) should equal (Some("-1"))
    }
    "move a Figure by 2 spaces" in {
      var x: Array[Option[String]] = Array(Some("A1"),Some("A2"),Some("B1"),Some("B2"),Some("B3"))
      val player3 = new Player()
      player3.figuren = x
      player3.move(Some("A1"),2) should equal (Some("B1"))
    }
    "move a Figure in an empty space" in {
      var x: Array[Option[String]] = new Array[Option[String]](10)
      var count1 = 0
      x.foreach(ins => {
      x(count1) = None: Option[String]
      count1 = count1 + 1
      })
      x(1)=Some("A1")
      val player3 = new Player()
      player3.figuren = x
      player3.move(Some("A1"),2) should equal (Some("A1"))
    }
  }
