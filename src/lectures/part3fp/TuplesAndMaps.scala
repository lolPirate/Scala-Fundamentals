package lectures.part3fp

object TuplesAndMaps extends App {

  // Finite ordered "Lists"
  val aTuple = new Tuple2[Int, String](2, "hello scala")
  val anotherTuple = (3, 4)
  // Tuple can hold utmost 22 elems
  // Accessing tuples
  println(aTuple._1)
  println(aTuple.copy(_2 = "good bye Java"))
  println(aTuple.swap)

  // Maps
  val aMap: Map[String, Int] = Map()
  val phoneBooks = Map(("James", 555), "Drake" -> 678).withDefaultValue(-1)
  println(phoneBooks)

  // ops
  println(phoneBooks.contains("Drake"))
  println(phoneBooks("Drake"))
  println(phoneBooks("James"))
  println(phoneBooks("Judy"))

  // adding a new pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBooks + newPairing
  println(newPhoneBook)

  // functions
  // map, flatmap, filter
  println(phoneBooks.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys, mapValues
  println(phoneBooks.view.filterKeys(x => x.startsWith("J")).toMap)
  // mapValues
  println(phoneBooks.view.mapValues(number => number * 10).toMap)

  val names = List("james", "jack", "daniel", "robert")
  println(names.groupBy(name => name.charAt(0)))
}
