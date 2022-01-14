/*val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "MenschAergereDichNicht",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.10",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test",
    libraryDependencies += ("org.scala-lang.modules" %% "scala-swing" % "3.0.0")
      .cross(CrossVersion.for3Use2_13)
  )
  .enablePlugins(JacocoCoverallsPlugin)
  
  libraryDependencies += "com.google.inject" % "guice" % "4.1.0"

  libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"

  libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.12" % "1.0.6"

  libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.6" */

name          := "MenschAergereDichNicht"
organization  := "de.htwg.se"
version       := "0.11.0"
scalaVersion  := "3.1.0"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.10"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"
crossScalaVersions ++= Seq("2.13.5", "3.0.2")

libraryDependencies += ("org.scala-lang.modules" %% "scala-swing" % "3.0.0")
      .cross(CrossVersion.for3Use2_13)

libraryDependencies += "com.google.inject" % "guice" % "4.2.3"

 libraryDependencies += ("net.codingwell" %% "scala-guice" % "5.0.2").cross(CrossVersion.for3Use2_13)
