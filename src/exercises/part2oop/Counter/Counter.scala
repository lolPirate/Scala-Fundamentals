package exercises.part2oop.Counter

class Counter(number: Int) {
  def currentCount(): Int = this.number

  def increment(): Counter = new Counter(this.number + 1)

  def increment(by: Int): Counter = new Counter(this.number + by)

  def decrement(): Counter = new Counter(this.number - 1)

  def decrement(by: Int): Counter = new Counter(this.number - by)

}

object Main extends App {
  var counter = new Counter(5)
  println(counter.currentCount())
  counter = counter.increment()
  println(counter.currentCount())
  counter = counter.decrement(4)
  println(counter.currentCount())
}
