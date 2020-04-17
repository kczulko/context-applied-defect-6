import Dependencies._

ThisBuild / scalaVersion     := "2.12.11"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.github.kczulko"
ThisBuild / organizationName := "kczulko"

addCompilerPlugin("org.augustjune" %% "context-applied" % "0.1.3")

lazy val root = (project in file("."))
  .settings(
    name := "context-applied-bug",
    libraryDependencies ++= Seq(
      "com.chuusai" %% "shapeless" % "2.3.3",
      "org.typelevel" %% "cats-effect" % "2.1.3",
      scalaTest % Test
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
