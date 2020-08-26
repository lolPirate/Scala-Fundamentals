package exercises.part2oop.NovelWriter

object Driver extends App {
  val author = new Writer("Conan", "Doyale", 1859)
  val book = new Novel("The Adventures of Sherlock Holmes", 1880, author)
  println(s"Name of the author is ${author.fullName()}")
  println(s"He wrote the book ${book.name} and published it at the age of ${book.authorAge()}")
  val revisedBook = book.copy(1890)
  println(s"Revision of the book was published in ${revisedBook.yearOfRelease} when he was ${revisedBook.authorAge()}")
}
