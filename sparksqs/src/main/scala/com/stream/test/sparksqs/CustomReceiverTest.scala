package com.stream.test.sparksqs

import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext

/**
 * working example to demonstrate the custom receiver..
 * 
 * it also has demonstration for various window operations..
 */
object CustomReceiverTest extends Main {

  val conf = new SparkConf().setAppName("this_streaming").setMaster("local[*]")
  //val ssc = new StreamingContext(conf, Seconds(1));

  //this is only for the below countdata streams evaluation..
  val ssc = new StreamingContext(conf, Seconds(3));
  
  ssc.sparkContext.setLogLevel(Level.ERROR.toString())
  
  /**
   * this must be enabled for countByValueWindow operation..
   */
  ssc.checkpoint("d:\\scala\\file\\checks")
  
  val customReceiverStream = ssc.receiverStream(new CustomReceiver("127.0.0.1", 9999))
  
  /**
   * foreachRDD has its own functionality. need to refer to the Spark docs for more details..
   */
  
  /**
   * it will use the dafault batch interval set on the spark streaming context.. and there will be no window in this case..
   */
  //val words = customReceiverStream.foreachRDD(_.flatMap(_.split(" ")).map { x => (x,1) }.reduceByKey(_+_).foreach(println))
  
  /**
   * There will be a window created with given window length and sliding interval ans as usual it will apply the reduce within the window..
   */
  //val reddata = customReceiverStream.flatMap (_.split(" ")).map(_.toInt).reduceByWindow((x:Int,y:Int)=>x+y, Seconds(10), Seconds(5)).print
  
  /**
   * There will be a window defined or created with given window length and sliding interval and as usual it will apply the reduceByKey within the window..
   * 
   * ...Bykey... functionality is be applicable only on pair rdd..
   */
  //val redbykeydata = customReceiverStream.flatMap (_.split(" ")).map(x=>(x.toInt, 1)).reduceByKeyAndWindow((x:Int,y:Int)=>x+y, Seconds(10), Seconds(5)).print
  
  /**
   * this will use the default batch interval set on the spark streaming context.. and there will be no window..
   */
  //val reddata = customReceiverStream.flatMap (_.split(" ")).map(_.toInt).reduce((x:Int,y:Int)=>x+y).print
  
  /**
   * Again this will use the default batch interval set on the spark streaming context.. and there will be no window in this case..
   */
  //val redbykeydata = customReceiverStream.flatMap (_.split(" ")).map(x=>(x.toInt, 1)).reduceByKey((x:Int,y:Int)=>x+y).print
  
  /**
   * it works on the plain raw data that this stream contains.. 
   */
  val countdata = customReceiverStream.countByValueAndWindow(Seconds(12), Seconds(6)).print
  
  /**
   * but here we apply some transformation before applying the window operation..
   */
  //val countdata = customReceiverStream.flatMap { _.split(" ") }.map(identity).countByValueAndWindow(Seconds(12), Seconds(6)).print
  //val countdata = customReceiverStream.flatMap { _.split(" ") }.map(_.toInt).countByValueAndWindow(Seconds(12), Seconds(6)).print
  customReceiverStream.window(Seconds(12))
  ssc.start()
  ssc.awaitTermination()
}
