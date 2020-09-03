package exercises.part2oop.InheritanceAndTraits


trait MyPredicate[-T] {
  def test(value: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(value: A): B
}

abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](newData: B): MyList[B]

  def printElements: String

  override def toString: String = s"[ ${printElements} ]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def flatmap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](newData: B): MyList[B] = new Cons(newData, Empty)

  override def printElements: String = " "

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  def flatmap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

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

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = {
    new Cons[B](h, tail ++ list)
  }

  override def flatmap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatmap(transformer)
  }
}

object ListTest extends App {
  var list: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  var list2: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.head)
  println(list.tail.head)
  list = list.add(4)
  println(list)
  println(list.map(new MyTransformer[Int, Int] {
    override def transform(value: Int): Int = value * 2
  }))
  println(list.filter(new MyPredicate[Int] {
    override def test(value: Int): Boolean = value % 2 == 0
  }))
  println(list ++ list2)
  println(list.flatmap(new MyTransformer[Int, MyList[Int]] {
    override def transform(value: Int): MyList[Int] = new Cons(value, new Cons[Int](value + 1, Empty))
  }))
}