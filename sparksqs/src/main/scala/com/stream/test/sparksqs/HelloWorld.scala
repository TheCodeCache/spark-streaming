package com.stream.test.sparksqs

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.time.Duration
import java.time.Instant
import java.util.UUID

import org.apache.commons.io.FileUtils
import org.apache.commons.lang3.StringUtils

import com.stream.test.util.SparkUtil

object HelloWorld extends Main {
  FileUtils.deleteDirectory(new File("D:\\outs\\sample"))
  println("hello world")
  val spark = SparkUtil.getSparkSession("xml-generator")

  val uuid = UUID.randomUUID()
  println(uuid.variant())
  println(uuid.version())

  Thread.sleep(1000)

  import spark.implicits._

  println("start_date1:", new java.util.Date())
  val start1 = Instant.now();

  val base = spark.sparkContext.parallelize(0 until 500000, 200)

  println(base.getNumPartitions)

  val df = spark.sparkContext.parallelize(0 until 500000, 200).toDF

  df.printSchema()
  println(df.rdd.getNumPartitions)

  val dir = new File("D:\\outs\\sample")

  if (!dir.exists()) dir.mkdirs()

//  df.foreachPartition(partition => {
//
//    println("first init")
//
//    partition.foreach(row => {
//
//      val uuid = UUID.randomUUID()
//      val cor = UUID.randomUUID()
//
//      val template =
//        s"""<root>
//  <some_tag>some_values</some_tag>
//  <pcn_id>$uuid</pcn_id>
//  <corelation-id>${cor}</corelation-id>
//  <other_tags>junk_values</other_tags>
//</root>"""
//
//      //val file = new File(dir + "\\" + uuid + ".txt")
//      val file = Paths.get(dir + "\\" + uuid + ".txt")
//
//      Files.write(file, template.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
//      row
//    })
//  })

  println("end_date1:", new java.util.Date())
  val end1 = Instant.now();
  val time1 = Duration.between(start1, end1).toMillis();
  println("1st dataframe timeElapsed(in minutes): ", time1 / 1000.0)

  println("files got generated")
  println("start_date2:", new java.util.Date())
  val start2 = Instant.now();
  println(dir.getAbsolutePath)

  val rdd = spark.sparkContext.wholeTextFiles(dir.getAbsolutePath, 200)
  println("whole text files rdd: ", rdd.getNumPartitions)
  val df2 = rdd.mapPartitions(partition => {

    println("second init")

    partition.map(record => {

      val pcn_id = StringUtils.substringBetween(record._2, "<pcn_id>", "</pcn_id>")
      val cor_id = StringUtils.substringBetween(record._2, "<corelation-id>", "</corelation-id>")
      val file_name = record._1
      (pcn_id, cor_id, file_name)
    })
  }).toDF("pcn_id", "co-relation_id", "file_name")

  df2.printSchema()
  df2.show(false)

  println("end_date2:", new java.util.Date())
  val end2 = Instant.now();
  val time2 = Duration.between(start2, end2).toMillis();
  println("2nd dataframe timeElapsed(in minutes): ", time2 / 1000.0)
  println("main thread / spark driver process exits")

}
