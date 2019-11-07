package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction)
  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // When you need Loops, use recursion

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString)
  }

  def aBigFunction(n: Int) : Int = {
    def aSamllerFunction(a: Int, b: Int): Int = a + b
    aSamllerFunction(n , n - 11)
  }

  /*
   1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
   */

  def greeting(name: String, age: Int): String = "Hi, my name is " + name + " and I am " + age + " years old."
  println(greeting("Sven", 25))

  /*
   2. Factorial Function 1 * 2 * 3 .. * n
   */

  def factorial(number: Int): Int = {
    if (number <= 0) 1
    else number * factorial(number - 1)
  }
  println(factorial(5))

  /*
   3. A Fibonacci function
      f(1) = 1
      f(2) = 2
      f(n) = f(n -1) + f(n -2)
   */

  def fibonacci(fibb: Int): Int = {
    if (fibb <= 2) 1
    else fibonacci(fibb - 1) + fibonacci(fibb - 2)
  }
  println(fibonacci(4))

  /*
   4. Tests if a number is prim
   */
  def isPrime(number: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else number % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(number / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
