package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  val nonInclusiveRange: Seq[Int] = 1 until 10
  nonInclusiveRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  // Lists
  val aList = List(1, 2, 3)
  println(aList)
  val prepended = 42 :: aList // +: list :+
  println(prepended)
  val apple = List.fill(5)("apple")
  println(apple)

  // Arrays
  val nArray = Array(1, 2, 3)
  println(nArray)
  val threeElemArray = Array.ofDim[Int](3)
  println(threeElemArray)
  threeElemArray.foreach(println) // Values initialized to default value

  // Arrays and Seq
  val numberSeq: Seq[Int] = nArray
  println(numberSeq)

  // Vectors
  val vector: Vector[Int] = Vector(1, 2, 3)

  // Vector vs Lists
  val max_runs = 1000
  val max_capacity = 10000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to max_runs
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(max_capacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / max_runs
  }

  // keeps reference to tree
  // updating element in middle takes long time
  val numbersList = (1 to max_capacity).toList
  // depth of tree is small
  // need to replace 32 element chunk
  val numbersVector = (1 to max_capacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))

}
