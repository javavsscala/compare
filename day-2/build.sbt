name := "Day-2"

version := "1.0"

scalaVersion := "2.11.5"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

//libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.2"

//for debugging sbt problems
//logLevel := Level.Debug
logLevel := Level.Info

scalacOptions += "-deprecation"

mainClass in Compile := Some("ScalaFibonacci")
