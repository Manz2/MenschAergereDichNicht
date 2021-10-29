import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import org.junit.Test
import org.junit.Assert.*

class MainSpec extends AnyWordSpec:
  "Main" should {
    "have a bar as String of form '+----+'"  +
    "|    |" + "+----+" in {
      field() should be ("+----+" + "\n")
    }
    "have a scalable bar" in {
      bar(1) should be ("+----+" + "\n")
      bar(2) should be ("+----+----+" + "\n")
    }
  }
  "have cells as String of form '|    |'" in {
    cells() should be("|    |" + "\n")
  }
  "have scalable cells" in {
    cells(1) should be("|    |" + "\n")
    cells(2) should be("|    |    |" + "\n")
  }
