package com.stream.test.sparksqs

/**
 * transform() operation testing.
 */
object StreamTest extends Main {

  import scala.util.matching.Regex

  val keyValPattern: Regex = "([0-9a-zA-Z- ]+)=([0-9a-zA-Z-#()/. ]+ | (\"))".r

  val input: String =
    """id=#A03300 name="top center" background=repeat-x"""

  println(input)
  println
  println

  for (patternMatch <- keyValPattern.findAllMatchIn(input))
    println(s"${patternMatch.group(1)}=${patternMatch.group(2)}")

}
