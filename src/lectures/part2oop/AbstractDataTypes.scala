package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract classes. defined by abstract
  // cannot be instantiated
  abstract class Animal {
    val creatureType: String

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("Crunch, Crunch")
  }

  // Traits
  trait Carnivore {

    def eat(animal: Animal): Unit

  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded { // Multiple classes and traits
    override val creatureType: String = "Crocodile"

    override def eat: Unit = println("nomnomnom")

    override def eat(animal: Animal): Unit = println(s"I'm eating a ${animal.creatureType}")
  }

  val croc = new Crocodile
  val dog = new Dog
  croc eat;
  croc eat dog

  // traits vs abstract classes
  // both abstract classes and traits can have abstract as well non abstract members
  // traits do not have constructor parameters
  // extends one class but mix in multiple traits
  // traits are behaviour; abstract class is a thing

}
