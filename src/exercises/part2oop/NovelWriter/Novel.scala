package exercises.part2oop.NovelWriter

class Novel(val name: String, val yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = this.yearOfRelease - author.dob

  def isWrittenBy(author: Writer): Boolean = if (this.author == author) true else false

  def copy(newYearOfRelease: Int): Novel = new Novel(this.name, newYearOfRelease, this.author)
}
