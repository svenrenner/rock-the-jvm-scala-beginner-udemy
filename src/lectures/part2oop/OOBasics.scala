package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Sven", 25)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet

  val writer = new Writer("Sven", "Renner", 1994)
  val imposter = new Writer("Sven", "Renner", 1994)

  println(writer.fullName)

  val novel = new Novel("My Book", 2006, writer)

  println(novel.authorAge)
  println(novel.isWrittenBy(writer)) // true
  println(novel.isWrittenBy(imposter)) // false
  println(novel.copy(2010))


  val counter = new Counter
  counter.increment.increment.increment
  counter.increment(10)
}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

}

/*
  Novel and a Writer

  Writer: first name, surname, year of birth
    - method fullname (first name + surname)

  Novel: name, year of release, author --> Writer
    - authorAge --> at the year of release
    - isWrittenBy (author)
    - copy (new year of release) = new Instance of Novel
 */

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName: String = s"$firstName $surname"
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {

  def authorAge: Int = yearOfRelease - author.yearOfBirth
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int) = new Novel(name, newYear, author)
}

/*
 Counter class
  - receivers an int value
  - method current Count
  - method to increment/decrement => return a new Counter
  - overload inc/dec to receive an amount => new Counter
 */

class Counter(val anInt: Int = 0) {
  def currentCount = anInt
  def increment: Counter = new Counter(anInt + 1) // immutability
  def increment(amount: Int) = new Counter(anInt + amount) //

  def decrement: Counter = new Counter(anInt - 1)
  def decrement(amount: Int) = new Counter(anInt - amount)
}

// class parameters are NOT fields