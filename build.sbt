val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "MenschAergereDichNicht",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalatest" % "junit-interface" % "0.11" % "test"
  )
