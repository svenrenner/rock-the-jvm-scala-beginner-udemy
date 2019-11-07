package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  // Type of val is optional
  val y = 42

  // Vals are immutable
  // x = 2

  val aString: String = "Hello"
  val anotherString = "Goodbye"

  val aBoolean: Boolean = true
  val anotherBoolean = false

  val aChar: Char = 'A'
  val anotherChar = 'B'

  val anInt = x

  val aShort: Short = 1
  val anotherShort = 2

  val aLong: Long = 1234567890L

  val aFloat: Float = 1.2f

  val aDouble = 1.2
  val anotherDouble: Double = 1.2

  // Variables --> Mutable
  var aVariable: Int = 4

  aVariable = 5 // Side effect

}
