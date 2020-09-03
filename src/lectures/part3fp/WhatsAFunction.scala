package lectures.part3fp

object WhatsAFunction extends App {

  // use functions as first class elements
  val doubler = new MyFunction[Int, Double] {
    override def apply(element: Int): Double = element * 2.0
  }
  println(doubler(4))
  // Function types = Function1 ...Function22
  // Function types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(stringToIntConverter("24"))

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  println(adder(4, 6))

  val hello = new Function0[String] {
    override def apply(): String = "hello"
  }
  println(hello())

  // 1. a function which takes 2 strings and concatenates them
  val concatenate = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println(concatenate("hello ", "world"))

  // 3. a function which takes an int and returns another function which takes an int and returns an int
  val funcGenerator = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }
  println(funcGenerator(1)(2))

}

trait MyFunction[A, B] {
  def apply(element: A): B
}