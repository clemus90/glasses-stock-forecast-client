val scala3Version = "3.0.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "stock-forecast-client",
    version := "0.1.0",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.client3" %% "core" % "3.3.11"
    )
  )
