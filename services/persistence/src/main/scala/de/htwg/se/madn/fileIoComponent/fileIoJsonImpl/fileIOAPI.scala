package de.htwg.se.madn
package fileIoComponent.fileIoJsonImpl

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives.*
import scala.io.StdIn
import play.api.libs.json._


import scala.concurrent.ExecutionContextExecutor
import scala.util.{Failure, Success}

object fileIOAPI {
    
  // needed to run the route
  implicit val system:ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
  // needed for the future flatMap/onComplete in the end
  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext

   val route = concat(
      path("fileio" / "load") {
        get {
          complete(HttpEntity(ContentTypes.`application/json`, fileIoJsonImpl.load()))
        }
      },
      path("fileio" / "save") {
      concat(
        post {
          entity(as[String]) { game =>
            fileIoJsonImpl.save(game)
            complete("game saved")
          }
        }
      )
    }
   )

   val bindingFuture = Http().newServerAt("0.0.0.0", 8080).bind(route)

    println(s"Server now online. Please navigate to http://localhost:8080/fileio\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
}
