lazy val gpsd4s =
  project.in(file("."))
  .aggregate(core)
  .settings(commonSettings: _*)

lazy val core =
  project.in(file("core"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= commonLibraries)
  .settings(
    name := "core"
  )


lazy val commonSettings = Seq(
  organization := "com.github.jw3",
  name := "gpsd4s",
  version := "0.1",
  scalaVersion := "2.12.2"
)


lazy val akkaVersion = "2.5.2"
lazy val akkaHttpVersion = "10.0.8"
lazy val scalatestVersion = "3.0.3"

lazy val commonLibraries = {
  Seq(
    "io.spray" %% "spray-json" % "1.3.3",

    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,

    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "ch.qos.logback" % "logback-classic" % "1.1.9",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",

    "org.scalactic" %% "scalactic" % scalatestVersion % Test,
    "org.scalatest" %% "scalatest" % scalatestVersion % Test,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test
  )
}
