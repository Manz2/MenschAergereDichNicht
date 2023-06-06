import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class MediumSpikeTest extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://localhost:8080")
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


  private val scn = scenario("MediumSpikeTest")
    .exec(
      http("request_0")
        .get("/fileio/load")
        .headers(headers_0)
    )
    .pause(10)
    .exec(
      http("request_1")
        .get("/fileio/load")
        .headers(headers_0)
    ).pause(10)
    .exec(
      http("request_2")
        .get("/fileio/load")
        .headers(headers_0)
    )

  setUp(scn.inject(atOnceUsers(1000))).protocols(httpProtocol)
}