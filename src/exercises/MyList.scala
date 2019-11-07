package exercises

abstract class MyList[+A] {

  def head(): A
  def tail(): MyList[A]
  def isEmpty: Boolean
  def add[B >: A](e: B): MyList[B]
  def printElements: String

  override def toString: String = "[" + printElements + "]"
}
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = boolean if the list is empty or not
    add = receives and Int and return a new List with the element added
    toString => a string representation of the list
   */


  object Empty extends MyList[Nothing] {
    def head(): Nothing = throw new NoSuchElementException
    def tail(): MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](e: B): MyList[B] = new Cons(e, Empty)
    def printElements: String = ""

  }

  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head: A = h
    def tail: MyList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](e: B): MyList[B] = new Cons(e, this)
    def printElements: String =
      if (t.isEmpty) "" + h
      else h + " " + t.printElements
  }

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)
  println(list.toString)

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfString: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers)
  println(listOfString)
}
