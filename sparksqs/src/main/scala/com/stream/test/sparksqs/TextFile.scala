package com.stream.test.sparksqs

import org.apache.hadoop.conf.Configuration

import com.stream.test.util.SparkUtil

object TextFile extends Main {
  val spark = SparkUtil.getSparkSession("xml-generator")
  val stageMetrics = ch.cern.sparkmeasure.StageMetrics(spark)
  //stageMetrics.runAndMeasure(spark.sql("select count(*) from range(1000) cross join range(1000) cross join range(1000)").show)
  val sc = spark.sparkContext
  val conf = new Configuration(sc.hadoopConfiguration)
  conf.set("textinputformat.record.delimiter", "X")
  //val input = sc.newAPIHadoopFile("src/main/resources/input.json", classOf[TextInputFormat], classOf[LongWritable], classOf[Text], conf)
  val input = sc.textFile("src/main/resources/input.json", 7)
  //val lines = input.map { case (_, text) => text.toString }

  val map1 = input.map(x => x * 2)
  val filter1 = map1.filter(x => true)
  val map2 = filter1.map(x => x * 3)
  val filter2 = map2.filter(x => x != "23")
  //val collect = filter2.collect()
  println("ToDebugString:")
  println(filter2.toDebugString)

  //stageMetrics.runAndMeasure(lines.collect.foreach(x => println(x + "\n\n")))

}
