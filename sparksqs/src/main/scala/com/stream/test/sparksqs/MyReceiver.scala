package com.stream.test.sparksqs

import org.apache.spark.internal.Logging
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.receiver.Receiver

class MyReceiver(n: Int) extends Receiver[String](StorageLevel.MEMORY_AND_DISK_2) with Logging {

  def onStart() {
    new Thread("Socket Receiver") {
      override def run() { receive() }
    }.start()
  }
  def onStop() {}

  private def receive() {
    while (!isStopped) {
      val string = MySource.generate(n)
      store(string)
      println("Recvd: ", string)
      val opt = scala.util.Try(Thread.sleep(100)).toOption
    }
    // Restart in an attempt to connect again when server is active again
    restart("Trying to connect again")
  }
}
