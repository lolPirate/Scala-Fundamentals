package lectures.part1basics

object ValuesVariablesTypes extends App {
  // value
  val aValue:Int = 42 //val is immutable
  println(aValue)

  //types
  val aBoolean:Boolean = true || false
  val aChar:Char = 'a'
  val anInt:Int = 999999999
  val aShort:Short = 9999
  val aLong:Long = 999999999999999999L
  val aFloat:Float = 9.0f
  val aDouble:Double = 9.0

  //variables
  var aVariable:Int = 9999999 //var is mutable
  // variables are used as side effects
  //Types are inferred
}
