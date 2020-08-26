package exercises.part2oop.NovelWriter

class Writer(firstName: String, lastName: String, val dob: Int) {
  def fullName(): String = s"${this.firstName} ${this.lastName}"
}
