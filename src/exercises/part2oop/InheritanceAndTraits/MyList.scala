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
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
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
}

object ListTest extends App {
  var list: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  var list2: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.head)
  println(list.tail.head)
  list = list.add(4)
  println(list)
  println(list.map(new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }))
  println(list.filter(new Function1[Int, Boolean] {
    override def apply(v1: Int): Boolean = v1 % 2 == 0
  }))
  println(list ++ list2)
  println(list2.flatmap(new Function1[Int, MyList[Int]] {
    override def apply(v1: Int): MyList[Int] = new Cons(v1, new Cons(v1 + 1, Empty))
  }))
  println(list2.map(x => x * 3))
}