package lectures.part2oop

// aliasing
import java.sql

import playground.{PrinceCharming, Cinderella => Princess}
import java.util.Date
import java.sql.{Date => SQLDate}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package -> see top
  val princess = new Princess
  val princessCin = new playground.Cinderella // fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  val date =  new Date
  // 1. use fully qualified name
  val sqlDate = new sql.Date(2018, 5, 4)
  // 2. use alias
  val sqlDateAlias = new SQLDate(2019, 5, 4)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
