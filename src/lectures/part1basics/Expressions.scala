package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>>

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /=     -->> Side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3 // if expression
  println(aConditionValue)
  println(if(aCondition) 5 else 3)

  // DON'T DO THIS
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // Everything in Scala is an Expression!
  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hello" else "Goodbye"
  }

  // 1. difference between "hello world" vs println("hello World") ?
  // --> println is an expression with side effect vs "hello world" is an assignment to String

  // 2. return boolean true

  val someValue = {
    2 < 3
  }

  println(someValue)

  // 3. returns int 42

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }

  println(someOtherValue)
}
