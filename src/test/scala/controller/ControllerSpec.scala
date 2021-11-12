package Documents.Htwg.se.MADN.MenschAergereDichNicht
package controller
import model.{Player, Field, Home}
import util.{Observer,Observable}
import Controller.{Controller}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class ControllerSpec extends AnyWordSpec with Matchers:
  "A Controller" when {
    "observed by an Observer" should {
      var z: Array[String] = new Array[String](2)
      //val smallfield = new Field(2,z)
      val smallHomefield = new Home(z)
      val smallPlayerfield = new Player(z)
      val observer = new Observer {
        var updated: Boolean = false
        def isUpdated: Boolean = updated
         override def update: Unit = updated = true
      }
      Controller.add(Observable)
      "notify its Observer after creation" in {
        var z: Array[String] = new Array[String](2)
        Controller.newGame(z,z,z)
        Observer.updated should be(true)
        //controller.grid.size should be(4)
      }
  }
}