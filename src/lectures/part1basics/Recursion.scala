package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }

  println(factorial(10))
  // Stackoverflow Error after 4500 tries
  //println(factorial(5000))

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(9, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 2 * 3 * 4 ... * 10 * 1)
    = return accumulator => 1 * 2 * 3 * 4 ... * 10
   */
  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if(x <= 1) accumulator
      else factHelper(x -1, x * accumulator) // Tail recursion = use recursive call as the LAST expression
    }
    factHelper(n,1)
  }

  println(anotherFactorial(10))
  println(anotherFactorial(5000))

  // When you need Loops, use TAIL RECURSION

  /*
   1. Concat a String n times using Tail Rec
   */

  @tailrec
  def concatRecursiv(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatRecursiv(aString, n - 1, aString + accumulator)
  }
  println(concatRecursiv("Hello", 3, ""))

  /*
  2. Prime Tail Rec function
  */
  def isPrime(number: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntil(t-1, number % t != 0 && isStillPrime)
    }
    isPrimeUntil(number / 2, true)
  }
  println(isPrime(2003))
  println(isPrime(629))

  /*
   3. Fibbonaci Tail Rec
   */
  def fibonacci(fibb: Int): Int = {
    @tailrec
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= fibb) last
      else fiboTailRec(i + 1, last + nextToLast, last)
    }
    if (fibb <= 2) 1
    else fiboTailRec(2, 1, 1)
  }
  println(fibonacci(8)) // 1 1 2 3 5 8 13 21
}
