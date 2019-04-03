name := "Equatorial"

version := "0.0.1"

scalaVersion := "2.12.6"

sbtVersion := "0.13.0"

libraryDependencies ++= Seq(
	"org.apache.tika"     %"tika-langdetect"     %"1.20" exclude("javax.ws.rs", "javax.ws.rs-api"),
    "jakarta.ws.rs" % "jakarta.ws.rs-api" % "2.1.4"
)