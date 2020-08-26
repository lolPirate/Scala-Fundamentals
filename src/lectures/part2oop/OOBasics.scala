package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Debamalya", 26)
  // println(person.age) // class parameters from the constructors are not fields we can access using . (dot)
  // one way to fix this is to add val or var to the constructor definition (1)
  println(person.age)
  println(person.x)
  person.greet("Chicken Pox")

}

class Person(name: String, val age: Int) { // <= constructor
  // body of class (not an expression per say)
  // val or var definitions inside a class body are fields
  // Every time an object is instantiated, the whole class body is evaluated. Hence the print statement comes first.
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name") // this is used to access current objects name
  // Though name is not a field, it is still available

  // Overloading (same name, different signatures and/or different return types)
  def greet(): Unit = println(s"Hi, I am $name!") // Same as this.name

  // multiple constructors
  def this(name: String) = this(name, 0) // Can only call primary or secondary constructors
  def this() = this("John Doe") // Example of secondary constructor calling another secondary constructor

}

// class Person(name: String, val age: Int) // <= constructor (1)