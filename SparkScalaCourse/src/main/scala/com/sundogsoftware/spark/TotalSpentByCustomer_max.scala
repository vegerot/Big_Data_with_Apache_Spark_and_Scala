package com.sundogsoftware.spark

import org.apache.spark.SparkContext

object TotalSpentByCustomer_max extends App {
  val sc = new SparkContext("local[*]", "TotalSpentByCustomer_max")

  sc
    .textFile("data/customer-orders.csv")
    .map(_.split(','))
    .map(r=>r(0)->r(2).toFloat)
    .reduceByKey((a,b)=>a+b)
    .map(_.swap)
    .sortByKey()
    .map(_.swap)
    .collect()
    .foreach(println)

}
