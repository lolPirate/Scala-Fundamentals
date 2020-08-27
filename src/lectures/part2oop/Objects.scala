package lectures.part2oop

object Objects extends App {

  // Scala has not concept of class level functionality i.e. It does not have static.

  class Person(name: String) {
    // instance level functionality
  }

  object Person { // type + its only instance
    // "static / class" level functionality
    val N_EYES = 2

    def canFly = false

    // factory methods
    def from(mother: Person, father: Person): Person = new Person("Bobbie")

    // Usual design pattern
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  // COMPANIONS - class person and object person are companions as they reside in same scope and has same name

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON
  val mary = Person // Person is the instance of the object and the only instance
  val john = Person // same as above
  println(mary == john) // prints out true as mary and john point to the same instance

  val margaret = new Person("Margaret")
  val maxy = new Person("Maxy")
  println(margaret == maxy) // false as different instances of class Person

  val bobbie = Person.from(margaret, maxy) // Factory usage
  val bryan = Person(margaret, maxy) // Using the apply method

  // Scala applications = Scala object with
  // def main(args: Array[String]): Unit
}
