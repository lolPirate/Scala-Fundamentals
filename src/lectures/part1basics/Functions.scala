package lectures.part1basics

object Functions extends App {
  def aFunction(param1:String, param2:Int):String = {
    param1 + " " + param2 // Implementation of a function is a single expression.
  }

  println(aFunction("Hello", 3))

  def aParamterLessFunction():Int = 42
  println(aParamterLessFunction())
  println(aParamterLessFunction) // Parameter Less Functions can be called just by their name

  def aRepeatedFunction(aString:String, aNumber:Int):String = {
    if (aNumber == 1) aString
    else aString + aRepeatedFunction(aString, aNumber - 1)
  }
  println(aRepeatedFunction("hello", 3))

  // In times of Loops, use Recursion (Fundamental difference between imperative programming and functional programming)

  def aBigFunction(n:Int):Int = {
    def aSmallFunction(m:Int):Int = m // Auxiliary function inside aBigFunctions code block
    aSmallFunction(n)
  }
  println(aBigFunction(96))
  /*
  1. A greeting function  (name, age) => "Hi, my name is $name and I am $ year(s) old!"
  2. Factorial function 1 * 2 * 3 * 4 * 5 ..... * n
  3. A Fibonacci function
     f(1) = 1
     f(2) = 1
     f(n) = f(n - 1) + f(n - 2)
  4. Function to test a prime number
   */

  // 1. A greeting function  (name, age) => "Hi, my name is $name and I am $ year(s) old!"
  def greetingFunction(name:String, age:Int):String = s"Hi, my name is $name and I am $age year(s) old!"
  println(greetingFunction("Debamalya", 26))

  // 2. Factorial function 1 * 2 * 3 * 4 * 5 ..... * n
  def factorial(n:Int):Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }
  val n = 5
  println(s"Factorial of $n is "+factorial(n))

  // 3. Fibonacci function
  def fibonacci(n:Int):Int = {
    if (n == 1 || n == 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
  val fibbo = 10
  println(s"The $fibbo fibonacci term is "+fibonacci(fibbo))

  // 4. Function to test a prime number
  def isPrime(n:Int):Boolean = {
    def isPrimeUntil(t:Int):Boolean =
      if (t <= 1) true else n % t != 0 && isPrimeUntil(t - 1)
    isPrimeUntil(n / 2)
  }
  val number = 10
  println(isPrime(number))
}
