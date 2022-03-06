package com.stream.test.sparksqs

import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.SparkConf
import org.apache.hadoop.io.{ LongWritable, Text }
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text

object FileStream extends Main {

  val conf = new SparkConf().setAppName("this_streaming").setMaster("local[*]")

  /**
   * this is how to register a class with kryo serialization
   */
  conf.registerKryoClasses(Array(classOf[LongWritable], classOf[Text]))

  val ssc = new StreamingContext(conf, Seconds(10));

  //val fileStream = ssc.fileStream("D:\\scala\\file") // results in java.lang.InstantiationException

  /**
   * org.apache.spark.SparkException: Job aborted due to stage failure: Task 0.0 in stage 0.0 (TID 0) had a not serializable result: org.apache.hadoop.io.LongWritable
   *
   * In order to resolve this, we must register the following type classes such as LongWritable, Text. However registering just LongWritable will work fine..
   */
  val fileStream = ssc.fileStream[LongWritable, Text, TextInputFormat]("files")

  /**
   * what is the significance of the below line..? the answer is :-
   * the significance is path1 will have args[0], something1 will have args[1] and so on.. and we can use it after this declaration/definition..
   * this is like assignment of args to a number of variables..
   * "it is just named assignment in the array args.."
   */
  //val List(path1, something1, something2, value1, anything) = args.toList

  fileStream.flatMap { x => Array(x._1.toString, x._2.toString) }.print()
  //fileStream.print()

  ssc.start()
  ssc.awaitTermination()
}
