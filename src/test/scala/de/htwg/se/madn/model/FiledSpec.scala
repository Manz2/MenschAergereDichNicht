package de.htwg.se.madn
import model.{Player, Field, Home}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class FiledSpec extends AnyWordSpec with Matchers:
  "Field" should {
    "create a small Filed of 2 cells" in {
      var z: Array[String] = new Array[String](2)
      val field = new Field(z)
      field.toString should contain only ('+', '-', '|', ' ', '\n')
      field.toString should contain allOf ('+', '-', '|', ' ', '\n')
      field.toString.count(_ == '+') should equal(6)
      field.toString.count(_ == '-') should equal(16)
      field.toString.count(_ == '|') should equal (3)
    }
    "create a big Filed of 10 cells" in {
      var x: Array[String] = new Array[String](10)
      val field2 = new Field(x)
      field2.toString should contain only ('+', '-', '|', ' ', '\n')
      field2.toString should contain allOf ('+', '-', '|', ' ', '\n')
      field2.toString.count(_ == '+') should equal(22)
      field2.toString.count(_ == '-') should equal(80)
      field2.toString.count(_ == '|') should equal (11)
    }
    "move a Figure by 10 spaces" in {
      var x: Array[String] = new Array[String](10)
      val field3 = new Field(x)
      field3.move("A1",1) should equal ("-1")
    }
    "move a Figure by 2 spaces" in {
      var x: Array[String] = Array("A1","A2","B1","B2","B3")
      val field3 = new Field(x)
      field3.move("A1",2) should equal ("B1")
    }
  }

