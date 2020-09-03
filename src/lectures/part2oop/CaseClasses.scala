package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. Class parameters are promoted to field
  val jim = new Person("Jim", 3)
  println(jim.name)
  // 2. Sensible toString
  println(jim)
  // 3. equals and hashcode implemented OOTB
  val jim2 = new Person("Jim", 3)
  println(jim == jim2)
  // 4. Have copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)
  // 5. Have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. Serializable
  // 7. Have extractor patterns => can be used in pattern matching

  case object UK {
    def name: String = "UK"
  }

}
