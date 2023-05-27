package de.htwg.se.madn

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives.*
import scala.io.StdIn
import play.api.libs.json._
import FieldComponent.FieldInterface
import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

object commandAPI {
  // needed to run the route
  implicit val system:ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
  // needed for the future flatMap/onComplete in the end
  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext

  trait Command {
    def doStep: FieldInterface
    def undoStep:FieldInterface
    def redoStep:FieldInterface
  }
  val route = concat(
      path("command" / "doMove") {
        post {
          entity(as[String]) { move =>
            println("move in capi: " + move)
            complete(HttpEntity(ContentTypes.`application/json`, UndoManager.doStep(move)))
          }
        }
      },
      path("command" / "undo") {
        get {
          println("undo in capi")
          val retVal = UndoManager.undoStep()
          println("retVal: " + retVal)
          complete(HttpEntity(ContentTypes.`application/json`, retVal))
        }
      },
      path("command" / "redo") {
        get {
          println("redo in capi")
          val retVal = UndoManager.redoStep()
          println("retVal: " + retVal)
          complete(HttpEntity(ContentTypes.`application/json`, retVal))
        }
      }

   )

   val bindingFuture = Http().newServerAt("0.0.0.0", 8081).bind(route)


    bindingFuture.onComplete{
      case Success(binding) => {
        val address = binding.localAddress
        println(s"File IO REST service online at http://localhost:8081/command/\nPress RETURN to stop...")
        StdIn.readLine() // let it run until user presses return
        bindingFuture
          .flatMap(_.unbind()) // trigger unbinding from the port
          .onComplete(_ => system.terminate()) // and shutdown when done
      }
      case Failure(exception) => {
        println("File IO REST service couldn't be started! Error: " + exception + "\n")
      }
    }
}
