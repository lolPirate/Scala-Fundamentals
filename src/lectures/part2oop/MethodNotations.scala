package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == this.favoriteMovie

    def hangsOutWith(person: Person): Unit = println(s"${this.name} is hanging out with ${person.name}")

    def unary_! : Unit = println(s"${this.name}, this is dope!")

    def isAlive: Boolean = true

    def apply(): String = s"Hi my name is ${this.name} and I like the movie ${this.favoriteMovie}"
  }

  val mary = new Person("Mary", "Batman")
  println(mary.likes("Inception"))
  println(mary likes "Batman") // Infix Notation or Operator Notation [Syntactic Sugar]
  // ^ Only works for methods with one parameter

  // "Operators" in scala
  val jane = new Person("Jane", "Inception")
  mary hangsOutWith jane // hangsOutWith is acting as an operator

  // Cool little example
  println(1 + 2)
  println(1.+(2)) // Same as above line as + is a method

  // Prefix Notation
  val x = -1 // - is an unary operator
  val y = 1.unary_- // is equivalent to x = -1
  println(x)
  println(y)
  // unary_ prefix only works with - + ~ !
  !jane

  // Postfix Notation
  println(mary.isAlive)
  println(mary isAlive)
  // Only available to parameter less methods

  // Apply
  println(mary.apply())
  println(mary()) // Equivalent. Th compiler looks for a definition of apply in that class


}
