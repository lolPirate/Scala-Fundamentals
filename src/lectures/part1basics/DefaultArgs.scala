package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  def factorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(number: Int, factorial: BigInt = 1): BigInt = { // Here factorial = 1 in parameter list is default value
      if (number <= 1) factorial
      else factorialHelper(number - 1, number * factorial)
    }

    factorialHelper(n)
  }

  println(factorial(100000))

  // Challenges
  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  savePicture("png", 800, 600) // Works fine as we can provide values to default parameters explicitly
  // savePicture(800, 600) // Does not work as 800 is interpreted as the first argument (format)
  // Can not omit leading default parameters

  /*
  Solution
  1. Pass in all the arguments
  2. Name the arguments (named arguments)
   */
  savePicture(width = 800) // Named Argument
  // Named arguments can be passed in any order as they are named

}
