package de.htwg.se.madn
package fileIoComponent.fileIoJsonImpl

import akka.http.scaladsl.server.Directives.{complete, concat, get, path}
import akka.actor.*
//import akka.http.*
//import akka.http.scaladsl.Http
//import akka.http.scaladsl.server.Directives.*
//import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCode}
//import akka.http.scaladsl.server.{ExceptionHandler, Route}

import scala.concurrent.ExecutionContextExecutor
import scala.util.{Failure, Success}

object fileIOAPI {
    
  // needed to run the route
  val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
  given ActorSystem[Any] = system
  // needed for the future flatMap/onComplete in the end
  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext


    val routes: String =
    """
        Welcome to the Persistence REST service! Available routes:
          GET   /fileio/load
          POST  /fileio/save
        """.stripMargin

    val route = concat(
    pathSingleSlash {
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, routes))
    },
    path("fileio" / "load") {
      get {
        complete(HttpEntity(ContentTypes.`application/json`, fileIoJsonImpl.load()))
      }
    },
    path("fileio" / "save") {
      concat(
        post {
          entity(as[JsValue]) { game =>
            fileIoJsonImpl.save(game)
            complete("game saved")
          }
        }
      )
    }
  )

  val bindingFuture = Http().newServerAt("0.0.0.0", 8081).bind(route)

  bindingFuture.onComplete{
    case Success(binding) => {
      val address = binding.localAddress
      println(s"File IO REST service online at http://localhost:${address.getPort}\nPress RETURN to stop...")
    }
    case Failure(exception) => {
      println("File IO REST service couldn't be started! Error: " + exception + "\n")
    }
  }
}
