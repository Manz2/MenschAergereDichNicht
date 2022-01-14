package de.htwg.se.madn
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

import model.PlayerComponent.PlayerInterface
import model.PlayerComponent.PlayerBaseImpl._
import model.HomeComponent.HomeInterface
import model.HomeComponent.HomeBaseImpl._
import model.FieldComponent.FieldInterface
import model.FieldComponent.fieldBaseImpl._

class HomeSpec extends AnyWordSpec:
  "Home" should {
    "create a small Home Filed of 2 cells" in {
      var z: Array[Option[String]] = new Array[Option[String]](2)
      var count1 = 0
      z.foreach(ins => {
      z(count1) = None: Option[String]
      count1 = count1 + 1
      })
      val home = new Home()
      home.figuren = z
      home.toString should contain only ('+', '-', '|', ' ', '\n')
      home.toString should contain allOf ('+', '-', '|', ' ', '\n')
      home.toString.count(_ == '+') should equal(6)
      home.toString.count(_ == '-') should equal(16)
      home.toString.count(_ == '|') should equal (3)
    }
    "create a big Home Filed of 10 cells" in {
      var x: Array[Option[String]] = new Array[Option[String]](10)
      var count1 = 0
      x.foreach(ins => {
      x(count1) = None: Option[String]
      count1 = count1 + 1
      })
      val home2 = new Home()
      home2.figuren = x
      home2.toString should contain only ('+', '-', '|', ' ', '\n')
      home2.toString should contain allOf ('+', '-', '|', ' ', '\n')
      home2.toString.count(_ == '+') should equal(22)
      home2.toString.count(_ == '-') should equal(80)
      home2.toString.count(_ == '|') should equal (11)
        
    }
    "move a Figure by 10 spaces" in {
      var x: Array[Option[String]] = new Array[Option[String]](10)
      var count1 = 0
      x.foreach(ins => {
      x(count1) = None: Option[String]
      count1 = count1 + 1
      })
      val home3 = new Home()
      home3.figuren = x
      home3.move(Some("A1"),1) should equal (Some("-1"))
    }
    "move a Figure by 2 spaces" in {
      var x: Array[Option[String]] = Array(Some("A1"),Some("A2"),Some("B1"),Some("B2"),Some("B3"))
      val home3 = new Home()
      home3.figuren = x
      home3.move(Some("A1"),2) should equal (Some("B1"))
    }
    "move a Figure in an empty space" in {
      var x: Array[Option[String]] = new Array[Option[String]](10)
      var count1 = 0
      x.foreach(ins => {
      x(count1) = None: Option[String]
      count1 = count1 + 1
      })
      x(1)=Some("A1")
      val home3 = new Home()
      home3.figuren = x
      home3.move(Some("A1"),2) should equal (Some("A1"))
    }

  }

