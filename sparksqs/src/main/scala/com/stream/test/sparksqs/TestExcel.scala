package com.stream.test.sparksqs

import java.io.File

import org.apache.commons.io.FileUtils

import com.stream.test.util.SparkUtil

object TestExcel extends Main {

  //FileUtils.deleteDirectory(new File("D:\\outs\\sample"))
  println("hello world")
  val spark = SparkUtil.getSparkSession("xml-generator")

  val df = spark.read.format("com.crealytics.spark.excel")
    //.option("location", "/FileStore/tables/Airline.xlsx")
    .option("header", "true")
    .option("treatEmptyValuesAsNulls", "false")
    .option("inferSchema", "false")
    .option("addColorColumns", "false")
    .load("src/main/resources/book11.xlsx")
  df.printSchema()
  df.show(5000, false)
}
