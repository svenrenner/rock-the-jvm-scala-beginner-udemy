package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long) : Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int) = println(x)

  // Stackoverflow Error because infinite is evaluated by Value
  //printFirst(infinite(), 34)

  // Works because infinite as Call by name is not evaluated
  printFirst(34, infinite())
 }
