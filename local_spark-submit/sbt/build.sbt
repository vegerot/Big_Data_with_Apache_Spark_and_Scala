name := "MinTemps"

version := "1.0"

organization := "com.sundogsoftware"

scalaVersion := "2.12.13"

libraryDependencies ++= Seq(
"org.apache.spark" %% "spark-core" % "3.1.1"  % "provided",
"org.apache.spark" %% "spark-sql" % "3.1.1"   % "provided"
)

mergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}
