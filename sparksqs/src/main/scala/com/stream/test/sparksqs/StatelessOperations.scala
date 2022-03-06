package com.stream.test.sparksqs

import org.apache.spark.SparkConf
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.DStream.toPairDStreamFunctions

/**
 * Join operation
 * we can open multiple DStreams for the stateless operation.. nad perform join related operations only if they are key-value DStreams..
 */
object StatelessOperations extends Main {

  val conf = new SparkConf().setAppName(this.getClass.getSimpleName).setMaster("local[*]")

  val ssc = new StreamingContext(conf, Seconds(15))

  val socket9999 = ssc.socketTextStream("127.0.0.1", 9999) //nc -lv 127.0.0.1 -p 9999

  val socket9998 = ssc.socketTextStream("127.0.0.1", 9998, StorageLevel.MEMORY_AND_DISK_SER_2) //nc -lv 127.0.0.1 -p 9998

  val s9 = socket9999.map { x => (x.split(" ")(0), x.split(" ")(1)) }
  val s8 = socket9998.map { x => (x.split(" ")(0), x.split(" ")(1)) }

  s9.join(s8).foreachRDD(rdd => rdd.foreach(println))

  ssc.start()
  ssc.awaitTermination()
}
