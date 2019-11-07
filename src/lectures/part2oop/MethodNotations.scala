package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_! : String = s"$name, unary Test"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
    def learns(whatToLearn: String): String = s"$name learns $whatToLearn"
    def learnsScala: String = learns("Scala")
  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "Inception")
  // infix notation = operator notation (example of syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // All operators are methods
  // Akka actors have ! ?

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
    1. Overload the + operator with a String and return a new Person with a Nickname
       ex. Mary + "the Rockstar" => new Person "Mary (the rockstar)"

    2. Add an age to the Person class with default value 0
       Add unary + operator => new Person with age + 1

    3. Add a "learns" method in Person class => input string => "Mary learns Scala"
       Add a learnsScala method, calls learns method with scala as parameter
       Use it in postfix notation

    4. Overload the apply method
       mary.apply(2) => "Mary watched Inception 2 times"
   */

  println((mary + "the Rockstar")())
  println((mary + "the Rockstar").apply())

  println((+mary).age)

  println(mary learnsScala)
  println(mary(10))
}
