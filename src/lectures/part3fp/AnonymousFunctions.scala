package lectures.part3fp

object AnonymousFunctions extends App {

  val doubler = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }
  // lambda function or anonymous function
  val doubler2: Int => Int = (x: Int) => x * 2
  // Currying lambda
  val trippler: Int => Int => Int = (x: Int) => (y: Int) => x * y
  println(trippler(3)(2))

  // no params
  val doSomething: () => Int = () => 3
  println(doSomething())
  println(doSomething.apply())

  // curly braces lambda
  val stringToInt = {
    (string: String) => string.toInt
  }

  // MOAR
  val niceIncrementer: Int => Int = (x: Int) => x + 1
  val shortHand: Int => Int = _ + 1 // MOAR (_ indicates no of unique parameters)
  val niceAdder: (Int, Int) => Int = _ + _ // (a: Int, b:Int) => a + b


}
