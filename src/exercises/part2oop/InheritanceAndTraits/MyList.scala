package exercises.part2oop.InheritanceAndTraits

/*
trait MyPredicate[-T] {
  def test(value: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(value: A): B
}
*/
abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](newData: B): MyList[B]

  def printElements: String

  override def toString: String = s"[ ${printElements} ]"

  def map[B](transformer: A => B): MyList[B]

  def flatmap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  def foreach(func: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], func: (A, B) => C): MyList[C]

  def fold[B](start: B)(func: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](newData: B): MyList[B] = new Cons(newData, Empty)

  override def printElements: String = " "

  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatmap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def foreach(func: Nothing => Unit): Unit = Empty

  override def sort(func: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], func: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("List lengths do not match")
    else Empty
  }

  override def fold[B](start: B)(func: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def withFilter(func: A => Boolean): MyList[A] = filter(func)

  def head: A = this.h

  def tail: MyList[A] = this.t

  def isEmpty: Boolean = false

  def add[B >: A](newData: B): MyList[B] = new Cons(newData, this)

  override def printElements: String =
    if (t.isEmpty) h.toString
    else h + " " + t.printElements

  override def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = {
    new Cons[B](h, tail ++ list)
  }

  override def flatmap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatmap(transformer)
  }

  override def foreach(func: A => Unit): Unit = {
    if (t.isEmpty) func(h)
    else {
      func(h)
      t.foreach(func)
    }
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) < 0) new Cons[A](x, sortedList)
      else new Cons[A](sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], func: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("List lengths do not match")
    else new Cons(func(head, list.head), t.zipWith(list.tail, func))
  }

  override def fold[B](start: B)(func: (B, A) => B): B = {
    val newStart = func(start, h)
    t.fold(newStart)(func)
  }
}

object ListTest extends App {
  var list: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  var list2: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  var list3 = Empty
  /*println(list.head)
  println(list.tail.head)
  list = list.add(4)
  println(list)
  println(list.map((x: Int) => x * 2))
  println(list.filter((x: Int) => x % 2 == 0))
  println(list ++ list2)
  println(list2.flatmap((x: Int) => new Cons[Int](x, new Cons[Int](x+1, Empty))))
  println(list2.map(x => x * 3))*/
  list2.foreach((x: Int) => println(x))
  println(list.zipWith(list2, (x: Int, y: Int) => x * y))
  //println(list3.zipWith(list, (x: Int, y: Int) => x * y))
  println(list.sort(_ - _))
  println(list.fold(0)(_ + _))

}