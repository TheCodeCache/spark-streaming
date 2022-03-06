package com.stream.test.sparksqs

import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.functions.lag
import org.apache.spark.sql.functions.lead
import org.apache.spark.sql.functions.row_number

import com.stream.test.util.SparkUtil
import org.apache.spark.sql.Encoders

object CatalystTest extends Main {

  object ReverseLinkedList {

    def main(args: Array[String]): Unit = {
      val list = List(1, 2, 3, 4)
      reverse(list).foreach(println)
    }

    val out = scala.collection.mutable.ListBuffer[Int]()

    def reverse(list: List[Int]): List[Int] = {
      if (list.isEmpty) {
        list.foreach(println)
        out.toList
      } else {
        reverse(list.slice(1, list.length))
        val currentElement = list(0)
        out.append(currentElement)
      }
      out.toList
    }
  }

  val names = Map("fname" -> "Al", "lname" -> "Alexander")

  for (pair <- names) {
    println(s"key: $pair._1")
    println(s"value: $pair._2")
  }

  for (key <- names.keys) {
    println(s"key: $key")
  }

  for (value <- names.values) {
    println(s"value: value")
  }

  //for (entry <- names.entry){ // names.entry does not exist, it's a compile time error
  // . . .
  //}

  ReverseLinkedList.main(null)
  System.exit(0)

  val spark = SparkUtil.getSparkSession("catalyst-test")
  import spark.implicits._

  //  val showdf = spark.sql("SHOW TABLES")
  //  println(showdf.rdd.toDebugString)
  //  showdf.explain(true)
  //  showdf.printSchema
  //  showdf.show(false)

  val orders1 = Seq((1, "user1"), (2, "user2"), (3, "user3"), (4, "user4")).toDF()
  val orders2 = Seq((3, "user3"), (5, "user5"), (2, "user2")).toDF()

  val data = spark.sparkContext.parallelize(Array(("C", 3), ("A", 1), ("B", 4), ("A", 2), ("B", 5)))
  data.reduceByKey(_ + _)
  val ddf = orders1.exceptAll(orders2)

  case class Aaa() { ??? }

  def apply(aa: Any) = { print(s"aa: $aa"); Aaa() }

  val test = CatalystTest(2)
  println(test)
  System.exit(0)
  val encoders = Encoders

  val dff = ddf /*.rdd.mapPartitionsWithIndex((index, iter) => {
    iter.map(x => (x.get(0), x.get(1)))
  }, false).toDF()*/
  println(dff.rdd.toDebugString)
  dff.explain(true)
  //dff.collect()

  val char = System.in.read()
  println(s"char: $char")

  //  val showdf = spark.sql("SHOW TABLES")
  //  println(showdf.rdd.toDebugString)
  //  showdf.explain(true)
  //  showdf.printSchema
  //  showdf.show(false)

  val ddddf = spark.sql("REFRESH TABLE DEFG")
  println(s"ddddf: ${ddddf}")
  ddddf.printSchema()

  //temp. exit
  System.exit(0)

  // Business object
  case class Persona(pid: String, name: String, age: Int)
  // The dataset to query
  val peopleDataset = Seq(
    Persona("001", "Bob", 28),
    Persona("002", "Joe", 34),
    Persona("001", "Bob", 32),
    Persona("002", "Joe", 13),
    Persona("001", "Bob", 15),
    Persona("002", "Joe", 17)).toDS

  println("# of partitions: ", peopleDataset.rdd.getNumPartitions)
  // The query to execute
  val query =
    peopleDataset
      .map(x => Persona(x.pid, x.name + "xc", x.age))
      .filter(y => y.age % 2 == 0)
      .map(x => Persona(x.pid, x.name + "vc", x.age))
      .filter(y => y.age % 4 == 0).groupBy("name").count().as("total")
  // Get Catalyst optimization plan
  println(query.rdd.toDebugString)
  println
  query.rdd.dependencies.foreach(x => println(x.rdd.id))
  println
  query.explain(extended = true)

  query.show(false)

  val exitCode = System.in.read()
  println("pgm is existed " + exitCode)
  //query.explain()

  val simpleData = Seq(
    ("James", "Sales", 3000),
    ("Michael", "Sales", 4600),
    ("Robert", "Sales", 4100),
    ("Maria", "Finance", 3000),
    ("James", "Sales", 3000),
    ("Scott", "Finance", 3300),
    ("Jen", "Finance", 3900),
    ("Jeff", "Marketing", 3000),
    ("Kumar", "Marketing", 2000),
    ("Saif", "Sales", 4100))
  var df = simpleData.toDF("employee_name", "department", "salary")
  //df.show()
  val windowSpec = Window.partitionBy("department").orderBy("salary")
  df = df.withColumn("row_number", row_number.over(windowSpec))

  df = df.withColumn("lead", lead(col("salary"), 2).over(windowSpec))
  df = df.withColumn("lag", lag(col("salary"), 2).over(windowSpec))
  //df.show()
  println
  df.explain(true)
  println
  df.rdd.toDebugString
  println
  println(df.rdd.dependencies)

}
