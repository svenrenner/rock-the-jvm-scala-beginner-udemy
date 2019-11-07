package lectures.part1basics

object DefaultArgs extends App {

  def trFact(x: Int, accumulator: BigInt = 1): BigInt = {
    if(x <= 1) accumulator
    else trFact(x -1, x * accumulator) // Tail recursion = use recursive call as the LAST expression
  }

  val fact10 = trFact(10)
  // Default Value overwritten
  val fact10x2 = trFact(10, 2)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = {
    println("saving picture")
  }

  savePicture()

  // Confuses Compiler
  //savePicture(800, 600)


  /*
   1. Pass in every leading argument
   */
  savePicture("bmp")

  /*
   2. Name the arguments
   */
  savePicture(width = 800)
  savePicture(height = 600, width = 800, format = "png")
}
