package com.stream.test.sparksqs

import scala.util.Random

object MySource {

  val alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
  def generate(n: Int): String =
    (1 to (if (n > 26) 26 else n)).map(_ => alpha(Random.nextInt(alpha.length))).mkString
}
