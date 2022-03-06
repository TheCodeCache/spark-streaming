//== Physical Plan ==
//*(3) Project [_1#2, _2#3]
//+- Generate replicaterows(sum#20L, _1#2, _2#3), [_1#2, _2#3], false, [_1#2, _2#3]
//   +- *(2) Filter (isnotnull(sum#20L) && (sum#20L > 0))
//      +- *(2) HashAggregate(keys=[_1#2, _2#3], functions=[sum(vcol#17L)], output=[_1#2, _2#3, sum#20L])
//         +- Exchange hashpartitioning(_1#2, _2#3, 200)
//            +- *(1) HashAggregate(keys=[_1#2, _2#3], functions=[partial_sum(vcol#17L)], output=[_1#2, _2#3, sum#22L])
//               +- Union
//                  :- LocalTableScan [vcol#17L, _1#2, _2#3]
//                  +- LocalTableScan [vcol#18L, _1#9, _2#10]
//
//== Physical Plan ==
//*(2) HashAggregate(keys=[_1#2, _2#3], functions=[], output=[_1#2, _2#3])
//+- Exchange hashpartitioning(_1#2, _2#3, 200)
//   +- *(1) HashAggregate(keys=[_1#2, _2#3], functions=[], output=[_1#2, _2#3])
//      +- *(1) BroadcastHashJoin [coalesce(_1#2, 0), coalesce(_2#3, )], [coalesce(_1#9, 0), coalesce(_2#10, )], LeftAnti, BuildRight, ((_1#2 <=> _1#9) && (_2#3 <=> _2#10))
//         :- LocalTableScan [_1#2, _2#3]
//         +- BroadcastExchange HashedRelationBroadcastMode(List(coalesce(input[0, int, false], 0), coalesce(input[1, string, true], )))
//            +- LocalTableScan [_1#9, _2#10]

package com.stream.test.sparksqs

import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext

object MyRecvTest extends Main {

  val conf = new SparkConf().setAppName("my_streaming").setMaster("local[*]")
  val ssc = new StreamingContext(conf, Seconds(3))
  ssc.sparkContext.setLogLevel(Level.ERROR.toString())

  ssc.checkpoint("src/main/resources/checkpoints/my1")

  val myReceiverStream = ssc.receiverStream(new MyReceiver(10))

  myReceiverStream.foreachRDD(rdd => { val (id, name) = (rdd.id, rdd.name); rdd.collect().foreach(println) })

  ssc.start()
  ssc.awaitTermination()
}
