val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "MenschAergereDichNicht",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.10",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"
  )
<<<<<<< HEAD
  .enablePlugins(JacocoCoverallPlugin)
=======
  .enablePlugins(JacocoCoverallsPlugin)
>>>>>>> d21712e01c2fb6222430e53b57a7940cf481b5e1
