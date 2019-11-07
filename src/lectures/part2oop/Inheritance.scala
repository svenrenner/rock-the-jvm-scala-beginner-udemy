package lectures.part2oop

object Inheritance extends App {

  // Single class inheritance
  sealed class Animal {
    val creatureType = "Wild"
    def eat = println("Eating")
  }

  class Cat extends Animal {
    def crunch  ={
      eat
      println("Eat Eat")
    }
  }

  val cat = new Cat


  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "Domestic"
    override def eat = {
      super.eat
      println("Another eat")
    }
  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (poly)
  val unknownAnimal: Animal = new Dog("KG")
  unknownAnimal.eat

  // overriding vs overloading

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - user final on the entire class
  // 3 - seal the class = extend classes in this file, prevent extension in other files

}
