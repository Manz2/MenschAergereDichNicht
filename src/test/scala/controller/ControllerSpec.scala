package Documents.Htwg.se.MADN.MenschAergereDichNicht
package test.controller
import model.{Player, Field, Home}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class ControllerSpec extends AnyWordSpec with Matchers:
  "A Controller" when {
    "observed by an Observer" schould {
      var z: Array[String] = new Array[String](2)
      val smallfield = new field(2,z)
      val smallHomefield = new home(z)
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
