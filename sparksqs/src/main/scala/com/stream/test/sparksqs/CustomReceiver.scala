package com.stream.test.sparksqs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import org.apache.spark.internal.Logging
import org.apache.spark.streaming.receiver.Receiver
import java.net.Socket
import org.apache.spark.storage.StorageLevel
import scala.util.Random

/**
 * Many overloaded store() methods of Receiver sealed abstract class is very very important as this stores the generated data to the place where the spark streaming reads it from..
 */
class CustomReceiver(host: String, port: Int)
    extends Receiver[String](StorageLevel.MEMORY_AND_DISK_2) with Logging {

  def onStart() {
    // Start the thread that receives data over a connection
    new Thread("Socket Receiver") {
      override def run() { receive() }
    }.start()
  }

  def onStop() {
    // There is nothing much to do as the thread calling receive()
    // is designed to stop by itself if isStopped() returns false
  }

  /** Create a socket connection and receive data until receiver is stopped */
  private def receive() {
    var socket: Socket = null
    var userInput: String = null
    try {
      // Connect to host:port
      socket = new Socket(host, port)

      // Until stopped or connection broken continue reading
      val reader = new BufferedReader(
        new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))
      userInput = reader.readLine()
      while(!isStopped && userInput != null) {
        store(userInput)
        userInput = reader.readLine()
      }
      reader.close()
      socket.close()

      // Restart in an attempt to connect again when server is active again
      restart("Trying to connect again")
    } catch {
      case e: java.net.ConnectException =>
        // restart if could not connect to server
        restart("Error connecting to " + host + ":" + port, e)
      case t: Throwable =>
        // restart if there is any other error
        restart("Error receiving data", t)
    }
  }
  /**
   * the while loop needs some attention.. as this plays some important role here. need to understand more on store() functionality 
   */
  private def customreceive(){
    //while (!isStopped) {
    	store(Random.nextInt() + " " + Random.nextInt())
    //}
    restart("Trying to connect again...")
  }
}
