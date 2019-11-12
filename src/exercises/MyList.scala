package exercises

abstract class MyList[+A] {

  def head(): A
  def tail(): MyList[A]
  def isEmpty: Boolean
  def add[B >: A](e: B): MyList[B]
  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  // concatenation
  def ++[B >: A](list: MyList[B]) : MyList[B]
}
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = boolean if the list is empty or not
    add = receives and Int and return a new List with the element added
    toString => a string representation of the list
   */


  case object Empty extends MyList[Nothing] {
    def head(): Nothing = throw new NoSuchElementException
    def tail(): MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](e: B): MyList[B] = new Cons(e, Empty)
    def printElements: String = ""

    def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
    def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
    def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

    override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  }

  case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head: A = h
    def tail: MyList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](e: B): MyList[B] = new Cons(e, this)
    def printElements: String =
      if (t.isEmpty) "" + h
      else h + " " + t.printElements

    /*
      [1,2,3].map(n * 2)
        = new Cons(2, [2,3].map(n *2))
        = new Cons(2, new Cons(4, [3].map(n * 2)))
        = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
        = new Cons(2, new Cons(4, new Cons(6, Empty))))
     */
    def map[B](transformer: MyTransformer[A, B]): MyList[B] =
      new Cons(transformer.transform(h), t.map(transformer))

    /*
      [1,2].flatMap(n => [n, n+1])
      = [1,2] ++ [2].flatMap(n => [n, n+1])
      = [1,2] ++ [2,3] ++ Empty.flatMAp(n => [n, n+1]
      = [1,2] ++ [2,3] ++ Empty
      = [1,2,2,3]
     */
    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
      transformer.transform(h) ++ t.flatMap(transformer)


    /*
      [1,2,3].filter(n % 2 == 0) =
        [2,3].filter(n % 2 == 0) =
        = new Cons[2, [3].filter(n % 2 == 0))
        = new Cons[2, Empty.filter(n % 2 = 0)]
        = new Cons(2, Empty)
     */
    def filter(predicate: MyPredicate[A]): MyList[A] =
      if (predicate.test(h)) new Cons(h, t.filter(predicate))
      else t.filter(predicate)

    /*
      [1,2] ++ [3,4,5]
      = new Cons(1, [2] ++ [3,4,5])
      = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
      = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
     */
    def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
  }

trait MyPredicate[-T]{
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B]{
  def transform(elem: A): B
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)
  println(list.toString)

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfString: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers)
  println(listOfString)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }))

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }))

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }))

  println(cloneListOfIntegers == listOfIntegers)

  /*
    1. Generic trait MyPredicate[-T] with a method test(T) => Boolean
    2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
    3. MyList:
      - map(transformer) => MyList
      - filter(predicate) => MyList
      - flatMap(transformer from A to MyList[B]) => MyList[B]

      class EvenPredicate extends MyPredicate[Int]
      class StringToIntTransformer extends MyTransformer[String, Int]

      [1,2,3].map(n * 2) = [2,4,6]
      [1,2,3,4].filter(n % 2) = [2,4]
      [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
   */
}
