package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  //println(x.length) // Crashes with NullPointerException

  // throwing and catching Exceptions
  //val weirdValue = throw new NullPointerException // Can be assigned but is returned Nothing

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes

  def getInt(withExceptions: Boolean): Int = if (withExceptions) throw new RuntimeException("No int for you") else 42

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a runtime exception")
  } finally {
    // Code executes no matter what
    println("finally")
    // does not influence return type
    // use for side effects
  }

  // Custom exceptions
  class MyException extends Exception

  val exception = new MyException
  throw exception
}
