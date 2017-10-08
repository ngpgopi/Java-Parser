
// Project name (artifact name in Maven)
name := "addressbook-level4-master"

// orgnization name (e.g., the package name of the project)
organization := "seedu.address"

version := "1.0-SNAPSHOT"

// project description
description := "Address Book Project"

// Enables publishing to maven repo
publishMavenStyle := false

// Do not append Scala versions to the generated artifacts
crossPaths := false

// This forbids including Scala related libraries into the dependency
autoScalaLibrary := false

logBuffered in Test := true

conflictManager := ConflictManager.strict

publishArtifact in Test := true

mainClass in (Compile,run) := Some("seedu.address.MainApp")

// library dependencies. (orginization name) % (project name) % (version)
libraryDependencies ++= Seq(
   "org.fxmisc.easybind" % "easybind" % "1.0.3",
   "org.controlsfx" % "controlsfx" % "8.40.11",
   "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4",
   "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.7.4" ,
   "com.google.guava" % "guava" % "20.0",
   "org.eclipse.jdt" % "org.eclipse.jdt.core" % "3.10.0",
   "commons-io" % "commons-io" % "2.5",
   "junit" % "junit" % "4.12" % "test" ,
   "org.testfx" % "testfx-core" % "4.0.5-alpha" % "test",
   "org.testfx" % "testfx-junit" % "4.0.5-alpha" % "test",
   "org.testfx" % "openjfx-monocle" % "1.8.0_20" % "test"
)
