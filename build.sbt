val scala3Version = "3.1.0"


lazy val commonSettings = Seq(
  scalaVersion := scala3Version,
  organization := "de.htwg.se",
  name := "MenschAergereDichNicht",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := scala3Version,
  libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.10",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test",
  libraryDependencies += ("org.scala-lang.modules" %% "scala-swing" % "3.0.0"),
  libraryDependencies += "com.google.inject" % "guice" % "4.2.3",
  libraryDependencies += ("net.codingwell" %% "scala-guice" % "5.0.2").cross(CrossVersion.for3Use2_13),
  libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.0.1",
  libraryDependencies += ("com.typesafe.play" %% "play-json" % "2.9.2").cross(CrossVersion.for3Use2_13),
  libraryDependencies += ("com.typesafe.akka" %% "akka-http" % "10.5.0"),
  //libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.3.9",
  libraryDependencies +="com.typesafe.akka" %% "akka-actor"    % "2.0.5",
  libraryDependencies +="com.typesafe.akka" %% "akka-slf4j"    % "2.0.5",
  libraryDependencies +="com.typesafe.akka" %% "akka-remote"   % "2.0.5",
  libraryDependencies +="com.typesafe.akka" %% "akka-agent"    % "2.0.5", 
  libraryDependencies +="com.typesafe.akka" %% "akka-testkit"  % "2.0.5"% "test",
  //https://repo1.maven.org/maven2/com/typesafe/akka/akka-actor_2.10/2.3.9/akka-actor_2.10-2.3.9.pom


  jacocoReportSettings := JacocoReportSettings(
    "Jacoco Coverage Report",
    None,
    JacocoThresholds(),
    Seq(JacocoReportFormats.ScalaHTML, JacocoReportFormats.XML), // note XML formatter
  "utf-8"),

  jacocoCoverallsServiceName := "github-actions",
  jacocoCoverallsBranch := sys.env.get("CI_BRANCH"),
  jacocoCoverallsPullRequest := sys.env.get("GITHUB_EVENT_NAME"),
  jacocoCoverallsRepoToken := sys.env.get("COVERALLS_REPO_TOKEN"),
)

lazy val root = project
  .in(file("."))
  .dependsOn(tools, model, ui, persistence)
  .aggregate(tools, model, ui, persistence)
  .settings(
    name := "MenschAergereDichNicht",
    version := "0.1.0-SNAPSHOT",
    commonSettings
  )
  .enablePlugins(JacocoCoverallsPlugin)


  lazy val model = (project in file("model"))
  .settings(
    name := "Madn-Model",
    version := "0.1.0-SNAPSHOT",
    commonSettings
  )

  lazy val ui = (project in file("ui"))
  .dependsOn(tools)
  .aggregate(tools)
  .settings(
    name := "Madn-UI",
    version := "0.1.0-SNAPSHOT",
    commonSettings
  )


  lazy val tools = (project in file("tools"))
  .dependsOn(model)
  .aggregate(model)
  .settings(
    name := "Madn-TOOLS",
    version := "0.1.0-SNAPSHOT",
    commonSettings
  )

  lazy val persistence = (project in file("persistence"))
  .dependsOn(model)
  .aggregate(model)
  .settings(
    name := "Madn-Persistence",
    version := "0.1.0-SNAPSHOT",
    commonSettings
  )