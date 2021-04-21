addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")
name := "MinTemperaturesDataset"

version := "0.1"

scalaVersion := "2.12.13"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.0.0",
  "org.apache.spark" %% "spark-sql" % "3.0.0",
)

mainClass in (Compile, run) := Some("com.sundogsoftware.spark.MinTemperaturesDataset")
