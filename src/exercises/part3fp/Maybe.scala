package exercises.part3fp

abstract class Maybe[+A] {
  def map[B](transformer: A => B): Maybe[B]

  def flatmap[B](transformer: A => Maybe[B]): Maybe[B]

  def filter(predicate: A => Boolean): Maybe[A]
}

case object MaybeNot extends Maybe[Nothing] {
  override def map[B](transformer: Nothing => B): Maybe[B] = MaybeNot

  override def flatmap[B](transformer: Nothing => Maybe[B]): Maybe[B] = MaybeNot

  override def filter(predicate: Nothing => Boolean): Maybe[Nothing] = MaybeNot

}

case class Just[+A](value: A) extends Maybe[A] {
  override def map[B](transformer: A => B): Maybe[B] = Just(transformer(value))

  override def flatmap[B](transformer: A => Maybe[B]): Maybe[B] = transformer(value)

  override def filter(predicate: A => Boolean): Maybe[A] = if (predicate(value)) this else MaybeNot

}

object MaybeTest extends App {
  val three = Just(3)
  println(three)
  println(three.map(_ * 2))
  println(three.flatmap(x => Just(x % 2 == 0)))
  println(three.filter(_ % 2 == 0))
}