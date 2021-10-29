package Documents.Htwg.se.MADN.MenschAergereDichNicht

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class MainSpec extends AnyWordSpec:
  "Main" should {
    "have a scalable field String of form'\n+----+\n|    |\n+----+'\n" in {
      Madn.field() should contain only ('+','-','|',' ','\n')
      Madn.field() should contain allOf ('+','-','|')
      Madn.field(2).count(_ == '+') should equal (6)
      Madn.field(2).count(_ == '-') should equal (16)
      Madn.field(2).count(_ == '|') should equal (3)
      Madn.field(10).count(_ == '+') should equal (22)
      Madn.field(10).count(_ == '-') should equal (80)
      Madn.field(10).count(_ == '|') should equal (11)
    }
    "have a scalable players String of form'\n+----+\n|    |\n+----+'\n" in {
      Madn.players() should contain only ('+','-','|',' ','\n')
      Madn.players() should contain allOf ('+','-','|')
      Madn.field(2).count(_ == '+') should equal (6)
      Madn.field(2).count(_ == '-') should equal (16)
      Madn.field(2).count(_ == '|') should equal (3)
      Madn.field(10).count(_ == '+') should equal (22)
      Madn.field(10).count(_ == '-') should equal (80)
      Madn.field(10).count(_ == '|') should equal (11)
    }
    "have a scalable home String of form'\n+----+\n|    |\n+----+'\n" in {
      Madn.home() should contain only ('+','-','|',' ','\n')
      Madn.home() should contain allOf ('+','-','|')
      Madn.field(2).count(_ == '+') should equal (6)
      Madn.field(2).count(_ == '-') should equal (16)
      Madn.field(2).count(_ == '|') should equal (3)
      Madn.field(10).count(_ == '+') should equal (22)
      Madn.field(10).count(_ == '-') should equal (80)
      Madn.field(10).count(_ == '|') should equal (11)
    }
  }