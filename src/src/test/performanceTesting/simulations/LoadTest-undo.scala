import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class LoadTEstUndo extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://localhost:8081")
    .inferHtmlResources()
    .disableAutoReferer
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
  
  private val headers_0 = Map(
  		"Cache-Control" -> "no-cache",
  		"Pragma" -> "no-cache",
  		"Proxy-Connection" -> "keep-alive"
  )


  private val scn = scenario("LoadTest-undo")
    .exec(
      http("request_0")
        .get("/command/undo")
        .headers(headers_0)
    )
    .pause(1)
    .exec(
      http("request_1")
        .get("/command/redo")
        .headers(headers_0)
    )

  setUp(scn.inject(atOnceUsers(100))).protocols(httpProtocol)
}