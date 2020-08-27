package exercises.part2oop.InheritanceAndTraits


abstract class MyList {
  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(newData: Int): MyList

  def printElements: String

  override def toString: String = s"[ ${printElements} ]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException

  def tail: MyList = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add(newData: Int): MyList = new Cons(newData, Empty)

  override def printElements: String = " "
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = this.h

  def tail: MyList = this.t

  def isEmpty: Boolean = false

  def add(newData: Int): MyList = new Cons(newData, this)

  override def printElements: String =
    if (t.isEmpty) h.toString
    else h + " " + t.printElements
}

object ListTest extends App {
  var list: MyList = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.head)
  println(list.tail.head)
  list = list.add(4)
  println(list)
}