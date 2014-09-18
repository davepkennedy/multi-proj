import sbt.Package.ManifestAttributes
import sbt._
import Keys._
import sbtassembly.Plugin._
import AssemblyKeys._

object MyBuild extends Build {
  lazy val buildSettings = Defaults.defaultSettings ++ Seq(
    version := "1.0",
    organization := "io.github.davepkennedy.App",
    scalaVersion := "2.11.1",
    mainClass in assembly := Some("io.github.davepkennedy.App"),
    jarName in assembly := s"${name.value}.jar"/*,
    packageOptions := Seq (ManifestAttributes(
      //("Main-Class", "io.github.davepkennedy.App")
    ))
    */
  )

  lazy val app = project
    .aggregate(foo,bar)
    .dependsOn(foo,bar)
    .settings(assemblySettings: _*)
    .settings(buildSettings: _*)


  lazy val foo = project.in(file("foo")).settings(scalaVersion := "2.11.1")

  lazy val bar = project.in(file("bar"))
  .settings(
  scalaVersion := "2.11.1",
  libraryDependencies ++= Seq(
    "com.fasterxml.jackson.core" % "jackson-core" % "2.2.1",
    "com.fasterxml.jackson.core" % "jackson-annotations" % "2.2.1",
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.1",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.4.1")
    )
}
