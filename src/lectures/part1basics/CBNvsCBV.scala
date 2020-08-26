package lectures.part1basics

object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = { // Evaluated value of the expression is passed
    println(s"By value of x is $x")
    println(s"By value of x is $x")
  }

  def calledByName(x: => Long): Unit = { // => Signifies the parameter will be called by name
    println(s"By name of x is $x") // Passed function called 1st time
    println(s"By name of x is $x") // Passed function called 2nd time
  }

  calledByValue(System.nanoTime()) // Expression first evaluated and the result sent as parameter
  calledByName(System.nanoTime()) // Expression itself is sent as parameter and is evaluated each time the expression is referred to

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int): Unit = println(x)

  //printFirst(infinite(),42) // This crashes as the infinite function tries to evaluate first since call by value
  printFirst(42, infinite()) // This works as the infinite function is called by value and is not evaluated as y is never called
}
