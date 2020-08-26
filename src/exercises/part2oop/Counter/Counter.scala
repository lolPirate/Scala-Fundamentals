package exercises.part2oop.Counter

class Counter(number: Int) {
  def currentCount(): Int = this.number

  def increment(): Counter = new Counter(this.number + 1)

  def increment(by: Int): Counter = {
    if (by <= 0) this
    else increment().increment(by - 1)
  }

  def decrement(): Counter = new Counter(this.number - 1)

  def decrement(by: Int): Counter = {
    if (by <= 0) this
    else decrement().decrement(by - 1)
  }

}

object Main extends App {
  var counter = new Counter(5)
  println(counter.currentCount())
  counter = counter.increment()
  println(counter.currentCount())
  counter = counter.decrement(4)
  println(counter.currentCount())
}
