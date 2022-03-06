package com.stream.test.sparksqs

import org.apache.spark.serializer.KryoRegistrator
import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Output
import com.esotericsoftware.kryo.io.Input

/**
 * Demonstration of MyKryoRegistrator
 */
/**
 * In the driver, we can set MyKryoRegistrator like this:-
 * 
 * val conf = new SparkConf()
 * conf.set("spark.kryo.registrator", "com.acme.KryoRegistrator")
 */
object MyKryoRegistrator extends KryoRegistrator{
  override def registerClasses(kryo: Kryo){
    /**
     * here we can register the class A using its own custom Serializer helper class..
     */
    //kryo.register(classOf[A], new CustomASerializer())
    
  }
}

class A 

object A

class CustomASerializer extends com.esotericsoftware.kryo.Serializer[A] {
  override def read(x$1: Kryo, x$2: Input, x$3: Class[A]): A = ???
  override def write(x$1: Kryo, x$2: Output, x$3: A): Unit = ???
}

class driver extends Main{
  val kryo: Kryo = ??? 
  kryo.register(classOf[A], new CustomASerializer());
}

