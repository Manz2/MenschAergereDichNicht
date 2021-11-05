package Documents.Htwg.se.MADN.MenschAergereDichNicht
import Documents.Htwg.se.MADN.MenschAergereDichNicht.{Player, Field, Home}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class PlayerSpec extends AnyWordSpec with Matchers:
  "Player" should {
    "create a small Player Filed of 2 cells" in {
      var z: Array[String] = new Array[String](2)
      val player = new Player(z)
      player.toString should contain only ('+', '-', '|', ' ', '\n')
      player.toString should contain allOf ('+', '-', '|', ' ', '\n')
      player.toString.count(_ == '+') should equal(6)
      player.toString.count(_ == '-') should equal(16)
      player.toString.count(_ == '|') should equal (3)
    }
    "create a bigger Player Filed of 10 cells" in {
      var x: Array[String] = new Array[String](10)
      val player2 = new Player(x)
      player2.toString should contain only ('+', '-', '|', ' ', '\n')
      player2.toString should contain allOf ('+', '-', '|', ' ', '\n')
      player2.toString.count(_ == '+') should equal(22)
      player2.toString.count(_ == '-') should equal(80)
      player2.toString.count(_ == '|') should equal (11)   
    }
  }
