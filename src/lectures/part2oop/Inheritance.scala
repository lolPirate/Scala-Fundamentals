package lectures.part2oop

object Inheritance extends App {

  // Single class inheritance
  class Animal {
    val creatureType = "Wild"

    def eat = println("eating") // private makes method only accessible from this class
    // protected allows access in class and subclasses
    protected def walk = println("walking")
  }

  class Cat extends Animal {
    def walksOnLegs = {
      walk
      println("Walking on legs")
    }
  }

  val kitten = new Cat
  kitten.eat
  // kitten.walk // does not work
  kitten walksOnLegs // works

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  class NewBorn(name: String) extends Person(name) // Looks at auxiliary constructor

  // Overriding
  /*class Dog extends Animal {
    override val creatureType: String = "Domestic"
    override def eat: Unit = println("Dog eating")
  }
  */

  class Dog(override val creatureType: String) extends Animal {
    override def eat: Unit = { // Super implementation
      super.eat
      println("Dog Eating")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // Type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("K10")
  unknownAnimal.eat // refers to dogs eat method

  // Super used to refer to parent

  // preventing overrides
  /*
    1. use keyword final before method
    2. use keyword final before class to prevent extensions
    3. seal the class. classes extended in current file but prevented in other files (keyword: sealed)
   */
}
