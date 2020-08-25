package lectures.part1basics

object Expressions extends App {

  // Everything in scala is and EXPRESSION!

  val x = 1 + 2 //Expression
  println(x)

  // operators => + - * /
  // bitwise operators => & | ^ << >> >>>(right shift with zero extension)

  // == != >= <= > <
  // logical operators => ! && ||

  // += -= *= /=

  var aVariable = 2
  aVariable += 1 // Side effects
  println(aVariable)

  // Instructions (Do) vs Expressions (Value and/or Type)

  // IF expression
  val aCondition = true
  val aConditionalValue = if(aCondition) 11 else 12 // Expression
  println(aConditionalValue)

  // Loop Example
  println("Loop Example")
  var i = 0
  while (i < 10){
    println(i)
    i += 1
  }

  // ^ NEVER DO THIS

  // Scala is EXPRESSIONS

  val aWeirdValue:Unit = (aVariable = 3) // Unit ==== void in other languages
  // Unit only takes value ()
  println(aWeirdValue)

  // Code Block
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "good bye"
    // Value of a code block is the value of its last expression.
    // In this case, the value will either be "hello" or "good bye"
  }
  println(aCodeBlock)

}
