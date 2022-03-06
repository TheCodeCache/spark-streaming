package com.stream.test.sparksqs

import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.SparkConf
import scala.collection.mutable.Queue
import org.apache.spark.rdd.RDD

/**
 * transform() will generate a new ""DStream"" out of a currently running DStream..
 * QueueStream
 */
object QueueStreaming extends Main {

  val conf = new SparkConf().setMaster("local[*]").setAppName("StreamingTransformExample")
  val ssc = new StreamingContext(conf, Seconds(5))

  /**
   * Queue stream implementation
   */
  val rdd1 = ssc.sparkContext.parallelize(Array(1, 2, 3))
  val rdd2 = ssc.sparkContext.parallelize(Array(4, 5, 6))
  val rdd3 = ssc.sparkContext.parallelize(Array(7, 8, 9))
  
  /**
   * "Each DStream is a collection of many RDDs (batches)" - we can justify this statement with the QueueStream..
   */
  val rddQueue = new Queue[RDD[Int]]
  
  rddQueue.enqueue(rdd1)
  rddQueue.enqueue(rdd2)
  rddQueue.enqueue(rdd3)
  

  val numsDStream = ssc.queueStream(rddQueue, true)
  val plusOneDStream = numsDStream.map(Predef.identity)
  plusOneDStream.print()

  /**
   * transform() implementation
   */
 /* val commonRdd = ssc.sparkContext.parallelize(Array(0))
  val combinedDStream = numsDStream.transform(rdd => (rdd.union(commonRdd)))
  combinedDStream.print()*/

  ssc.start()
  ssc.awaitTerminationOrTimeout(8000)
}
