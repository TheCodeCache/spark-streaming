# Kafka with Spark Streaming –  

**Spark Streaming Application –**  

```scala
package com.local.streams.kafka_spark

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.SparkConf
import org.apache.log4j.Level

object SparkStreamApp extends scala.App {
  
  System.setProperty("hadoop.home.dir", "C:\\Users\\U1159927\\Desktop\\marsh\\winutils")
  
  val conf = new SparkConf().setAppName("this_streaming").setMaster("local[*]")
  //val ssc = new StreamingContext(conf, Seconds(1));

  //this is only for the below countdata streams evaluation..
  val streamingContext = new StreamingContext(conf, Seconds(10));
  
  streamingContext.sparkContext.setLogLevel(Level.INFO.toString())
  
  /**
   * this must be enabled for countByValueWindow operation..
   */
  streamingContext.checkpoint("C:\\kafka_spark_workspace\\checkpoints")
  
  val kafkaParams = Map[String, Object](
    "bootstrap.servers" -> "localhost:9092",
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer],
    "group.id" -> "use_a_separate_group_id_for_each_stream",
    "auto.offset.reset" -> "latest",
    "enable.auto.commit" -> (false: java.lang.Boolean))

  val topics = Array("test")
  val stream = KafkaUtils.createDirectStream[String, String](
    streamingContext,
    PreferConsistent,
    Subscribe[String, String](topics, kafkaParams))

  val dd = stream.map(record => (record.key, record.value))
  
  dd.print()
  // add business logic here
  
  streamingContext.start()
  streamingContext.awaitTermination()
}
```

**Kafka Producer –**  

![image](https://user-images.githubusercontent.com/26399543/157167996-7ffabda4-3d7f-4b58-9119-e3887c7f90ed.png)  


