package Documents.Htwg.se.MADN.MenschAergereDichNicht
import Documents.Htwg.se.MADN.MenschAergereDichNicht.{Player, Field, Home}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class HomeSpec extends AnyWordSpec:
  "Home" should {
    "create a Filed of cells" in {
      var z: Array[String] = new Array[String](2)
      val home = new Home(2,z)
      home.toString should contain only ('+', '-', '|', ' ', '\n')
      home.toString should contain allOf ('+', '-', '|', ' ', '\n')
      home.toString.count(_ == '+') should equal(6)
      home.toString.count(_ == '-') should equal(16)
      home.toString.count(_ == '|') should equal (3)

      /*var x: Array[String] = new Array[String](10)
      val field2 = new Field(10,z)
      field2.toString should contain only ('+', '-', '|', ' ', '\n')
      field2.toString should contain allOf ('+', '-', '|', ' ', '\n')
      field2.toString.count(_ == '+') should equal(22)
      field2.toString.count(_ == '-') should equal(80)
      field2.toString.count(_ == '|') should equal (11)*/
        
    }
  }

