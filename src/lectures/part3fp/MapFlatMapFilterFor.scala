package lectures.part3fp

import scala.annotation.tailrec

object MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val number = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')

  @tailrec
  def applyCombi(num: Int, list: List[Char]): Unit = {
    if (!list.isEmpty) {
      println(s"${list.head}$num")
      applyCombi(num, list.tail)
    }
  }

  number.map((x) => applyCombi(x, chars))
  // Iterations
  val combinations = number.flatMap(n => chars.map(c => s"${c}${n}"))
  println(combinations)

  // foreach
  list.foreach(println)

  // for-comprehension
  val forComprehension = for {
    n <- number
    c <- chars
  } yield (s"${c}${n}")
  println(forComprehension)

  import exercises.part2oop.InheritanceAndTraits._

  val mylist = Cons(1, new Cons(2, new Cons(3, Empty)))
  mylist.foreach(println)
  val forMyListComprehension = for {
    n <- mylist if n % 2 == 0
  } yield (n)
  println(forMyListComprehension)


}
