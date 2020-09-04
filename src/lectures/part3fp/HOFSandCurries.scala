package lectures.part3fp

object HOFSandCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x)))
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  val increment = (x: Int) => x + 1
  println(nTimes(increment, 6, 2))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))
  }

  val incrementTenTimes = nTimesBetter(increment, 10)
  println(incrementTenTimes(2))

  // Curried function
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val addWith3 = superAdder(3)
  println(addWith3(4))

  // Multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  println(standardFormat(Math.PI))

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = {
    (x: Int) => (y: Int) => f(x, y)
  }

  val curried = toCurry((x, y) => x + y)
  println(curried(2)(3))

  def fromCurry(f: Int => Int => Int): (Int, Int) => Int = {
    (x: Int, y: Int) => f(x)(y)
  }

  println(fromCurry(curried)(2, 3))

  def compose[A, B, T](f: B => T, g: A => B): A => T = {
    (x: A) => f(g(x))
  }

  val composed = compose[Int, Int, Int](
    (x) => x * x,
    (y) => y + y
  )
  println(composed(3))

}
