package com.profile.codeblock

object Timer extends scala.App {

  def timer[A](blockOfCode: => A) = {
    val startTime = System.nanoTime
    val result = blockOfCode
    val stopTime = System.nanoTime
    val delta = stopTime - startTime
    println("result::", result)
    (result, delta / 1000000d)
  }

  val (result, time) = timer { println("Hello"); var x = 5; x += 1; x; }
  println("result: ", result)
  println("time: ", time)

  /*val code = q"""println("compiled and run at runtime!")"""
  val compiledCode = toolbox.compile(code)
  val result = compiledCode()*/
}
