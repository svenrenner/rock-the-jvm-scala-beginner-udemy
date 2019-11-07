package lectures.part2oop

object Objects extends App {

  // Scala does not have class-level functionality ("static")
  object Person { // type + its only instance
    // "static" or "class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  // Companions

  println(Person.N_EYES)
  println(Person canFly)

  // Scala object = Singleton instance by definition
  val mary = Person
  val john = Person

  println(mary == john)

  val maryClass = new Person("Mary")
  val johnClass = new Person("John")
  println(maryClass == johnClass)


  val bobby = Person(maryClass, johnClass)

  // Scala applications = Scala object with
  // def main(args: Array[String]): Unit


}
