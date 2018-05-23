object Main {
    
  def main(args: Array[String]) {

    val getter = new Getter()
    val substitute = new Substitute()
    val fitness = new Fitness()
    val crossover = new Crossover()

    val cipher408 = getter.execute(
      appDir = System.getProperty("user.dir"),
      filename = "zodiac_408.txt"
    )

    val cipher340 = getter.execute(
      appDir = System.getProperty("user.dir"),
      filename = "zodiac_340.txt"
    )

    val population = scala.collection.mutable.Map[Map[Char, String], Double]()

    for (i <- 1 to 10) {
      val letterMap = substitute.execute(cipher340)
      val fitness_score = fitness.execute(cipher340, letterMap)
      population += (letterMap -> fitness_score)

    }

    val child = crossover.execute(cipher340, population)
  }
}