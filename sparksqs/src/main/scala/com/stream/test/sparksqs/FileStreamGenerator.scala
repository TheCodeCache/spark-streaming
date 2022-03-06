package com.stream.test.sparksqs

import scala.io.Source
import java.io.{ PrintWriter, File }
import scala.util.Random
import java.io.BufferedWriter
import java.io.FileWriter

/**
 * This class will keep generating streams of files containing random text. this class must be run prior to running FileStream.scala
 */
object FileStreamGenerator extends Main {

  //Source.fromFile("D:\\scala\\file\\test.txt").foreach(print)
  new Thread() {
    override def run() {

      for (index <- 0 until 20) {
        val randomNum = Random.nextInt()
        val file = new File("D:\\stream_inputs\\all_files\\file_" + randomNum + ".txt")
        println(file.exists())
        if (file.exists())
          file.delete()
        file.createNewFile()

        val writer = new BufferedWriter(new FileWriter(file))

        //val writer = new PrintWriter(file)

        writer.write("file starts..")
        writer.write("hey this is " + randomNum + " pen.. ")
        writer.write("file ends..")

        writer.flush()
        writer.close()
        Thread.sleep(2000)
      }
    }
  }.start()
}
