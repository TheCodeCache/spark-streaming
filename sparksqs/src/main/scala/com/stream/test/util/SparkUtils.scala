package com.stream.test.util

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import scala.collection.Map

object SparkUtils {
  /**
   * setting the winutils path by configuring hadoop home to the winutils directory
   */
  System.setProperty("hadoop.home.dir", "D:\\winutils");
  
  def getSparkConfiguration(appName: Class[_], thread: String) = {val conf = new SparkConf().setAppName(appName.getSimpleName).setMaster("local[" + thread + "]"); /*conf.set("hadoop.home.dir", "D:\\scala\\hadoop")*/ conf}
  def getSparkContext(appName: Any, thread: String) = new SparkContext(getSparkConfiguration(appName.getClass, thread))
  
  /**
   * shortcut to printing all the elements of the array
   */
  def printElements(x:Array[_]) = x.foreach(println)
  def printElements(x:Map[_,_]) = x.foreach{case (key, value)=> println(key+"::"+value)}
  def printElements2(x:Map[_,_]) = x.foreach(x=> println(x._1+"::"+x._2))
  def printElements3(x:Map[_,_]) = for((key, value) <- x) println(key+"::"+value)
  def printElements4(x:Map[_,_]) = for((key, value) <- x) yield println(key+"::"+value)
}
