package com.stream.test.util

import scala.collection.Map

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object SparkUtil {
  /**
   * setting the winutils path by configuring hadoop home to the winutils directory
   */
  System.setProperty("hadoop.home.dir", "D:\\winutils");

  def getSparkConfiguration(appName: Class[_], thread: String) = { val conf = new SparkConf().setAppName(appName.getSimpleName).setMaster("local[" + thread + "]"); conf.set("spark.sql.orc.enabled", "true");/*conf.set("hadoop.home.dir", "D:\\scala\\hadoop")*/ conf }
  def getSparkContext(appName: Any, thread: String) = new SparkContext(getSparkConfiguration(appName.getClass, thread))

  def getSparkSession(appName: Any, thread: String = "*") = SparkSession.builder().config(getSparkConfiguration(appName.getClass, thread)).appName(this.getClass.getSimpleName).getOrCreate()
  
  def getSparkSessionForHive(appName: Any, thread: String = "*") = SparkSession.builder().config(getSparkConfiguration(appName.getClass, thread)).appName(this.getClass.getSimpleName).enableHiveSupport().getOrCreate()

  def setProps(ss: SparkSession): Unit = {
    //For Lab
    /*ss.sparkContext.hadoopConfiguration.set("fs.s3a.access.key", "AKIAIW4Z4RNSWHPADYIA")
    ss.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key", "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")*/
    /*
     * older dev credentials
     * 
     * AKIAIY4KLWBJWZBE7F7Q
     * bEe3JLHdFW1s6mJDJefdjsVOMURnHhSxT2InMi8I
     */
    //For Dev
    //ss.sparkContext.hadoopConfiguration.set("fs.s3a.access.key", "AKIAI6SJG4ODYZBPO7ZQ")
    //ss.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key", "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")

    //ss.sparkContext.hadoopConfiguration.set("fs.s3.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")
    //ss.sparkContext.hadoopConfiguration.set("mapreduce.fileoutputcommitter.algorithm.version", "2")
    //Enabling fs.s3a.fast.upload upload parts of a single file to Amazon S3 in parallel
    //spark.speculation false
    
    //ss.sparkContext.hadoopConfiguration.set("spark.sql.orc.impl", "hive")
  }

  /**
   * shortcut to printing all the elements of the array
   */
  def printElements(x: Array[_]) = x.foreach(println)
  def printElements(x: Map[_, _]) = x.foreach { case (key, value) => println(key + "::" + value) }
  def printElements2(x: Map[_, _]) = x.foreach(x => println(x._1 + "::" + x._2))
  def printElements3(x: Map[_, _]) = for ((key, value) <- x) println(key + "::" + value)
  def printElements4(x: Map[_, _]) = for ((key, value) <- x) yield println(key + "::" + value)
}
