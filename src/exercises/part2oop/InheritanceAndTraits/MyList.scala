package exercises.part2oop.InheritanceAndTraits


abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](newData: B): MyList[B]

  def printElements: String

  override def toString: String = s"[ ${printElements} ]"
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](newData: B): MyList[B] = new Cons(newData, Empty)

  override def printElements: String = " "
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = this.h

  def tail: MyList[A] = this.t

  def isEmpty: Boolean = false

  def add[B >: A](newData: B): MyList[B] = new Cons(newData, this)

  override def printElements: String =
    if (t.isEmpty) h.toString
    else h + " " + t.printElements
}

object ListTest extends App {
  var list: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.head)
  println(list.tail.head)
  list = list.add(4)
  println(list)
}