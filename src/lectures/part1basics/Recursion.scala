package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Long = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(50))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec // Helps compiler understand that the function should be tail recursive
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }

    factorialHelper(n, 1)
  }

  println(anotherFactorial(50))

  // WHEN YOU NEED LOOPS, USE TAIL RECURSION
  /*
  1. Concatenate a string n times
  2. isPrime function with tail recursion
  3. Fibonacci number with tail recursion
   */

  // 1. Concatenate a string n times
  def concatenate(string: String, times: Int): String = {
    @tailrec
    def concatenateHelper(string: String, times: Int, accumulator: String): String = {
      if (times == 1) accumulator
      else concatenateHelper(string, times - 1, accumulator + string)
    }

    concatenateHelper(string, times, "")
  }

  println(concatenate("Hello", 26))

  // 2. isPrime function with tail recursion
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntil(t - 1, n % t != 0 && isStillPrime)

    isPrimeUntil(n / 2, false)
  }

  val number = 17
  println(isPrime(number))

  // 3. Fibonacci number with tail recursion
  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciHelper(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciHelper(i + 1, nextToLast + last, last)
    }

    fibonacciHelper(2, 1, 1)
  }

  println(fibonacci(2))
}
