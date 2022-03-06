package com.stream.test.sparksqs

import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream.toPairDStreamFunctions

/**
 * For any Stateful transformations we must set the checkpoint directory..
 */
object UpdateStatusBykeyStreaming extends Main {

  /**
   * this function will be invoked every time when ever a new batch interval starts..
   * and is invoked for every pair accumulated so far from all the previous streams..
   * in order to visualize this please track the accumulator value over every batch interval..
   * moreover, we can not access the key here inside this function..
   *
   */
  def updateFunc(values: Seq[Int], state: Option[Int]): Option[Int] = {
    acc += 1
    println("acc inside func::" + acc.value)
    val currentCount = values.sum
    val previousCount = state.getOrElse(0)
    Some(currentCount + previousCount)
  }

  val conf = new SparkConf().setAppName("this_streaming").setMaster("local[*]")

  val ssc = new StreamingContext(conf, Seconds(10))
  val acc = ssc.sparkContext.accumulator(0)

  /**
   * to start this tcp server use nc -lvp 9999
   */
  val line = ssc.socketTextStream("localhost", 9999)

  /**
   * this directory will move into D:/ drive by default in Windows..
   */
  ssc.checkpoint("/home/asus/checkpoints/") // Here ./checkpoints/ are the directory where all checkpoints are stored.

  val words = line.flatMap(_.split(" "))
  val pairs = words.map(word => (word, 1))

  val globalCountStream = pairs.updateStateByKey(updateFunc)
  println("invoke counts::" + acc.value)
  globalCountStream.print()

  ssc.start() // Start the computation
  ssc.awaitTermination()
}
