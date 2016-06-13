name := "crashyactor"

version := "1.0"

scalaVersion := "2.11.8"

val akkaVersion = "2.4.7"

scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation", "-Xcheckinit",
                      "-Xlint", "-Xfatal-warnings", "-g:line",
                      "-Ywarn-dead-code",  "-Ywarn-numeric-widen")

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-actor"      % akkaVersion  % Compile,
    "com.typesafe.akka" %% "akka-testkit"    % akkaVersion  % Test,
    "org.scalatest"     %% "scalatest"       % "2.2.4"      % Test
  )
}

mainClass in (Compile, run) := Some("org.derekmorr.Runner")
