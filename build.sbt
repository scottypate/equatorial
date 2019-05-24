name := "equatorial"
version := "0.0.1"
scalaVersion := "2.12.6"
sbtVersion := "1.2.8"

libraryDependencies ++= Seq(
	"org.apache.tika"     %"tika-langdetect"     %"1.20" exclude("javax.ws.rs", "javax.ws.rs-api"),
    "jakarta.ws.rs" % "jakarta.ws.rs-api" % "2.1.4"
)

// Deal with duplicate dependency paths.
// More detail here https://github.com/sbt/sbt-assembly#merge-strategy
assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}
