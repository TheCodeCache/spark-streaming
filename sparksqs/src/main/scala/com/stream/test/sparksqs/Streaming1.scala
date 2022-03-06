package com.stream.test.sparksqs

import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.storage.StorageLevel
import com.stream.test.util.SparkUtils

object Streaming1 extends Main {
  val conf = SparkUtils.getSparkConfiguration(this.getClass, "*")
  val ssc = new StreamingContext(conf, Seconds(1))

  val lines = ssc.socketTextStream("127.0.0.1", 9999, StorageLevel.MEMORY_AND_DISK_SER)

  val words = lines.flatMap(_.split(" "))

  val pairs = words.map(x => (x, 1))

  val wordCounts = pairs.reduceByKey(_ + _)
  wordCounts.print()

  ssc.start()
  ssc.awaitTermination()
}
