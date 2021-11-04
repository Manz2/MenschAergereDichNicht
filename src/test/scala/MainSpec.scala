import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class MainSpec extends AnyWordSpec:
  "Main" should {
    "have a bar as String of form '+----+'"  +
    "|    |" + "+----+" in {
      Madn.field() should include ("+----+" + "\n")
    }
    "have a scalable bar" in {
      Madn.players(1) should be ("+----+" + "\n")
      Madn.players(2) should be ("+----+----+" + "\n")
    }
  }
  "have cells as String of form '|    |'" in {
    Madn.home() should be("|    |" + "\n")
  }
  "have scalable cells" in {
    Madn.home(1) should be("|    |" + "\n")
    Madn.home(2) should be("|    |    |" + "\n")
  }
