package de.htwg.se.madn

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives.*
import scala.io.StdIn
import play.api.libs.json._
import FieldComponent.FieldInterface


import scala.concurrent.ExecutionContextExecutor
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
            complete(HttpEntity(ContentTypes.`application/json`, UndoManager.doStep(move)))
          }
        }
      },
      path("command" / "undo") {
        get {
          complete(HttpEntity(ContentTypes.`application/json`, UndoManager.undoStep()))
        }
      },
      path("command" / "redo") {
        get {
          complete(HttpEntity(ContentTypes.`application/json`, UndoManager.redoStep()))
        }
      }

   )

   val bindingFuture = Http().newServerAt("localhost", 8081).bind(route)

    println(s"Server now online. Please navigate to http://localhost:8080/fileio\nPress RETURN to stop...")

  
}
