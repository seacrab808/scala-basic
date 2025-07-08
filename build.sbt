ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "playground",
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % "0.14.3",
      "io.circe" %% "circe-generic" % "0.14.3",
      "io.circe" %% "circe-parser" % "0.14.3",
      "org.scalatest" %% "scalatest" % "3.2.15" % Test,
      ("org.scala-lang.modules" %% "scala-parser-combinators" % "2.2.0")
        .cross(CrossVersion.for3Use2_13),
    ),
  )
