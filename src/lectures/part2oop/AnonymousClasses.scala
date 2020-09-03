package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("HAHAHAHA")
  }
  /*
  class AnonymousClasses$$1anon$1 extends Animal {
    override def eat: Unit = println("HAHAHAHA")
  }
  val funnyAnimal : Animal = new AnonymousClasses$$1anon$1
   */

  funnyAnimal.eat
  println(funnyAnimal.getClass)

  class Person(val name: String) {
    def sayHi: Unit = println(s"Hello, my name is $name")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hello, my name is $name and how can i help ?")
  }
  println(jim.name)
  jim.sayHi
}
