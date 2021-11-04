package Documents.Htwg.se.MADN.MenschAergereDichNicht
import Documents.Htwg.se.MADN.MenschAergereDichNicht.{Player, Field, Home}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class FiledSpec extends AnyWordSpec:
  "Field" should {
    "create a Filed of cells" in {
      var z: Array[String] = new Array[String](2)
      val field = new Field(2,z)
      field.toString should contain only ('+', '-', '|', ' ', '\n')
      field.toString should contain allOf ('+', '-', '|', ' ', '\n')
      field.toString.count(_ == '+') should equal(6)
      field.toString.count(_ == '-') should equal(16)
      field.toString.count(_ == '|') should equal (3)

      /*var x: Array[String] = new Array[String](10)
      val field2 = new Field(10,z)
      field2.toString should contain only ('+', '-', '|', ' ', '\n')
      field2.toString should contain allOf ('+', '-', '|', ' ', '\n')
      field2.toString.count(_ == '+') should equal(22)
      field2.toString.count(_ == '-') should equal(80)
      field2.toString.count(_ == '|') should equal (11)*/
        
    }
  }

