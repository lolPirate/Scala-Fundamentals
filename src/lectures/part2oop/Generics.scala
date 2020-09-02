package lectures.part2oop

object Generics extends App {

  class MyList[+A] { // Generic class
    // use generic type G here
    def add[B >: A](element: B): MyList[B] = new MyList[B]

    // add method takes type b super type of a and element will be type b and returns a b type list
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  class MyMap[Key, Value] // Works for multiple generic types

  trait MyTrait[Type] // Works for traits as well

  // generic methods
  object MyList {
    def empty[G]: MyList[G] = ???
  }

  // val emptyListOfIntegers = MyList.empty[Int]

  // variance problem

  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // List of cat extends list of animals (COVARIANCE)
  class CovariantList[+A] // CovariantList
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog) ??? => Would work but would pollute animalList which is a list of cat

  // List of cat and list of animal are separate (INVARIANT)
  class Invariant[G]

  val invariantAnimalList: Invariant[Animal] = new Invariant[Animal]

  // val invariantAnimalList2: Invariant[Animal] = new Invariant[Cat] // Does not work

  // Contravariance
  class ContravariantList[-A]

  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded Types
  // Lower bound => Received should be a subclass
  class Cage[C <: Animal](animal: C)

  val cage = new Cage[Dog](new Dog)

  // class Car
  // val newCage = new Cage(new Car) // Would not wor as car does not extend Animal

  // Upper Bound => Received should be a superclass
  class AnotherCage[AC >: Cat](animal: AC)

  val anotherCage = new AnotherCage[Animal](new Animal)


}
