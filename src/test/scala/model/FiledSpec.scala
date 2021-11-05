package Documents.Htwg.se.MADN.MenschAergereDichNicht
import Documents.Htwg.se.MADN.MenschAergereDichNicht.model.{Player, Field, Home}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class FiledSpec extends AnyWordSpec with Matchers:
  "Field" should {
    "create a small Filed of 2 cells" in {
      var z: Array[String] = new Array[String](2)
      val field = new Field(2,z)
      field.toString should contain only ('+', '-', '|', ' ', '\n')
      field.toString should contain allOf ('+', '-', '|', ' ', '\n')
      field.toString.count(_ == '+') should equal(6)
      field.toString.count(_ == '-') should equal(16)
      field.toString.count(_ == '|') should equal (3)
    }
    "create a big Filed of 10 cells" in {
      var x: Array[String] = new Array[String](10)
      val field2 = new Field(10,x)
      field2.toString should contain only ('+', '-', '|', ' ', '\n')
      field2.toString should contain allOf ('+', '-', '|', ' ', '\n')
      field2.toString.count(_ == '+') should equal(22)
      field2.toString.count(_ == '-') should equal(80)
      field2.toString.count(_ == '|') should equal (11)
    }
  }

