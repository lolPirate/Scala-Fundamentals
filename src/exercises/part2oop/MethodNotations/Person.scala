package exercises.part2oop.MethodNotations

class Person(val name: String, val favoriteMovie: String, val age: Int = 0) {

  def likes(movie: String): Boolean = movie == this.favoriteMovie

  def hangsOutWith(person: Person): Unit = println(s"${this.name} is hanging out with ${person.name}")

  def +(person: Person): Unit = println(s"${this.name} is hanging out with ${person.name}")

  def +(nickName: String): Person = new Person(this.name + s" (${nickName})", this.favoriteMovie)

  def unary_! : Unit = println(s"${this.name}, this is dope!")

  def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

  def isAlive: Boolean = true

  def apply(): String = s"Hi my name is ${this.name} and I like the movie ${this.favoriteMovie}"

  def apply(number: Int): String = s"${this.name} watched the movie ${this.favoriteMovie} $number times."

  def learns(subject: String): String = s"${this.name} learns $subject"

  def learnsScala: String = learns("Scala")

}

object Driver extends App {
  val peter = new Person("Peter", "Spider Man")
  val jane = new Person("Jane", "Spider Man")
  peter + jane
  println(peter isAlive)
  println((peter + "Spider Man").name)
  println((+peter).age)
  println(peter learns "Web Swinging")
  println(peter learnsScala)
  println(peter(5))


}
