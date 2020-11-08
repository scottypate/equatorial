name := "equatorial"
version := "0.0.1"
scalaVersion := "2.12.6"
sbtVersion := "1.2.8"

libraryDependencies ++= Seq(
  "org.scalactic" % "scalactic_2.13.0-RC2" % "3.1.0-SNAP11" % "test",
  "org.scalatest" % "scalatest" % "1.4.RC2" % "test",
  "org.apache.tika" % "tika-langdetect" % "1.20" exclude ("javax.ws.rs", "javax.ws.rs-api"),
  "jakarta.ws.rs" % "jakarta.ws.rs-api" % "2.1.4"
)
