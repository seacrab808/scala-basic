package lecture

import scala.jdk.Accumulator

object Recursion extends App {
  def factorialIterative(n: Int): BigInt = {
    var result = BigInt(1)
    for(i <- 2 to n) { // both ends are inclusive
      result *= i
    }
    result
  }
  println(factorialIterative(3))

  def factorialStackRecursive(n: Int): Int = {
    if (n <= 1) 1
    else n * factorialStackRecursive(n - 1)
  }
  println(factorialStackRecursive(3))

//  @tailrec
  def factorialTailRecursive(n: Int, accumulator: Int = 1): Int = {
    if (n <= 1) accumulator
    else factorialTailRecursive(n - 1, n * accumulator)
  }
  println(factorialTailRecursive((3)))

//  @tailrec
  def concaternateRecursion(word: String, count: Int, accumulator: String): String = {
    if (count <= 0) accumulator
    else concaternateRecursion(word, count - 1, word + " " + accumulator)
  }
  println(concaternateRecursion("Hello", 3, ""))
}
