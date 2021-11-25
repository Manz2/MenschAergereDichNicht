package de.htwg.se.madn
import model.{Player, Field, Home}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class HomeSpec extends AnyWordSpec:
  "Home" should {
    "create a small Home Filed of 2 cells" in {
      var z: Array[String] = new Array[String](2)
      val home = new Home(z)
      home.toString should contain only ('+', '-', '|', ' ', '\n')
      home.toString should contain allOf ('+', '-', '|', ' ', '\n')
      home.toString.count(_ == '+') should equal(6)
      home.toString.count(_ == '-') should equal(16)
      home.toString.count(_ == '|') should equal (3)
    }
    "create a big Home Filed of 10 cells" in {
      var x: Array[String] = new Array[String](10)
      val home2 = new Home(x)
      home2.toString should contain only ('+', '-', '|', ' ', '\n')
      home2.toString should contain allOf ('+', '-', '|', ' ', '\n')
      home2.toString.count(_ == '+') should equal(22)
      home2.toString.count(_ == '-') should equal(80)
      home2.toString.count(_ == '|') should equal (11)
        
    }
    "move a Figure by 10 spaces" in {
      var x: Array[String] = new Array[String](10)
      val home3 = new Home(x)
      home3.move("A1",1) should equal ("-1")
    }
  }

