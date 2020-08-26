package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  // String operations
  // JAVA specifics
  println(str.charAt(2)) // same as println(str(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace("I am", "I'm"))
  println(str.toLowerCase())
  println(str.toUpperCase())

  // Scala Utilities
  val aNumberString = "45"
  println(aNumberString.toInt)
  println('a' +: aNumberString) // Prepending
  println('z' +: aNumberString :+ 'a') // Appending
  println(aNumberString.reverse)
  println(aNumberString.take(1))

  // String Interpolators

  // S - Interpolators
  val name = "Debamalya"
  val age = 26
  val greeting = s"Hello, I'm $name and my age is $age" // s is used for S - Interpolation
  println(greeting)
  val anotherGreeting = s"Hello, I'm $name and my age is ${age + 1}" // can solve expressions
  println(anotherGreeting)

  // F - Interpolators
  val speed = 1.2f
  // val myth = s"$name can eat $speed%2.2f burgers per minute" // Debamalya can eat 1.2%2.2f burgers per minute
  val myth = f"$name can eat $speed%2.2f burgers per minute" // Debamalya can eat 1.20 burgers per minute
  println(myth)

  // raw - Interpolator
  println(raw"This is a new line character => \n") // Prints things as it is (This is a new line character => \n)
}
