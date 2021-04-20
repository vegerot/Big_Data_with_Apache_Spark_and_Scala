package com.sundogsoftware.spark

import com.sundogsoftware.spark.DataFramesDataset.Person
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object FriendsByAgeDataset_max extends App {


  Logger.getLogger("org").setLevel(Level.ERROR)

  // Use new SparkSession interface in Spark 2.0
  val spark = SparkSession
    .builder
    .appName("SparkSQL")
    .master("local[*]")
    .getOrCreate()

  // Convert our csv file to a DataSet, using our Person case
  // class to infer the schema.
  import spark.implicits._
  val people = spark.read
    .option("header", "true")
    .option("inferSchema", "true")
    .csv("data/fakefriends.csv")
    .as[Person]

  people
    .select(people("age"), people("friends"))
    .groupBy("age")
    .mean("friends")
    .sort()
    .show();

}
