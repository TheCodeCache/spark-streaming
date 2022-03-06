package com.stream.test.sparksqs

import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.dstream.DStream.toPairDStreamFunctions

object Streaming extends scala.App {

  System.setProperty("hadoop.home.dir", "D:\\winutils")

  val conf = new SparkConf().setAppName("this_streaming").setMaster("local[*]")

  val ssc = new StreamingContext(conf, Seconds(5));
  ssc.checkpoint("D:\\stream_inputs\\all_files\\checks")

  //val stream = ssc.socketTextStream("127.0.0.1", 9999) // use nc -lv 127.0.0.1 -p 9999
  //val stream = ssc.textFileStream("D:\\scala\\file")

  //stream.print()

  //val ans = ssc.fileStream("D:\\scala\\file") // this we need to look at back again..
  /**
   * In order to work with this, we must run the FileStreamGenerator.scala process in order to generate the stream of files..
   */
  val ans = ssc.textFileStream("D:\\stream_inputs\\all_files") // this is a special version for textFileStream processing..

  ans.flatMap { _.split(" ") }.map { x => (x, 1) }.reduceByKey(_ + _).print()

  //print(ClassTag(ans.getClass))
  //ans.print()

  ssc.start()
  ssc.awaitTermination()

}
