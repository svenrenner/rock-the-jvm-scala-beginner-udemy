package lectures.part2oop

import java.nio.BufferOverflowException

object Exceptions extends App {

  val x: String = null
  //println(x.length)
  //

  // 1. throwing exceptions

  //val aWeirdValue = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime exeception")
  } finally {
    // code will get executed no matter what
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  // 3. How to define your own Exceptions
  class MyException extends Exception
  //val exception = new MyException
  //throw exception

  // 1. Crash your program with an OutOfMemoryError
  // OOM
  // val array = Array.ofDim(Int.MaxValue)

  // 2. Crash your program with a StackOverFlowError
  //def infinite: Int = 1 + infinite
  //val noLimit = infinite

  /*
    3. PocketCalculator
        - add(x,y)
        - subtract(x,y)
        - multiply(x,y)
        - divide(x,y)

        Throw
          - OverflowException if add(x,y) exceeds Int.MAX_VALUE
          - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
          - MathCalculationException for division by 0
   */

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException() extends RuntimeException("Division by Zero")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if(x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def mutliply(x: Int, y:Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  //println(PocketCalculator.add(Int.MaxValue, 10))
  //println(PocketCalculator.divide(2,0))
}
