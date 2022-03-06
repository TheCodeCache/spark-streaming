package com.stream.test.sparksqs

import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.log4j.Level

/**
 * window operations
 */
object WindowStreaming extends Main {

  val conf = new SparkConf().setAppName("this_streaming").setMaster("local[*]")
  val ssc = new StreamingContext(conf, Seconds(3))
  ssc.checkpoint("D:\\scala\\file\\checks")
  ssc.sparkContext.setLogLevel(Level.ERROR.toString)
  val dataStream = ssc.socketTextStream("127.0.0.1", 9999, StorageLevel.MEMORY_AND_DISK)

  /**
   * this will return a new DStream of data.. Moreover, these DStream may have overlapped data depending upon the sliding interval duration..
   *
   * From here on, the below stream will be treated as if it's a new DStream of which batch interval is the sliding interval of dataStream..
   * this point is crucial in order to understand the further window operations that will be called upon this stream..
   *
   */
  val stream = dataStream /*.window(Seconds(12), Seconds(6))*/

  //val counts = stream.flatMap { _.split(" ") }.map { x => (x,1) }.reduceByKey(_+_)
  //val counts = stream.reduceByWindow(_+_, Seconds(20), Seconds(10))
  /**
   * this operation requires checkpoint directory to be set to work properly..
   *
   * see for the detailed description on below stream above..
   * it returns the key value pair with the frequency of occurrences of values in the window..
   */
  //val counts = stream.countByValueAndWindow(Seconds(12), Seconds(6))

  /**
   * this returns just the count of words. it will always give only one value per window..
   */
  /*val counts = stream.countByWindow(Seconds(12), Seconds(6))

  counts.print(1000)*/

  val runningCountStream = stream.flatMap { _.split(" ") }.map { x => (x, 1) }.reduceByKeyAndWindow(
    (x: Int, y: Int) => x + y,
    (x: Int, y: Int) => x - y, // Subtract counts going out of window
    Seconds(12), Seconds(6), 2,
    (x: (String, Int)) => x._2 != 0)

  runningCountStream.countByWindow(Seconds(12), Seconds(6))

  ssc.start()
  ssc.awaitTermination()
}
