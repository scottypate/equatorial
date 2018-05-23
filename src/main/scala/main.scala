import scala.collection.immutable.ListMap

object Main {
    
  def main(args: Array[String]) {

    val getter = new Getter()
    val substitute = new Substitute()
    val fitness = new Fitness()
    val crossover = new Crossover()
    val blender = new Blender()

    val cipher408 = getter.execute(
      appDir = System.getProperty("user.dir"),
      filename = "zodiac_408.txt"
    )

    val cipher340 = getter.execute(
      appDir = System.getProperty("user.dir"),
      filename = "zodiac_340.txt"
    )

    val parents = scala.collection.mutable.Map[Map[Char, String], Double]()
    val offspring = scala.collection.mutable.Map[Map[Char, String], Double]()

    // Create the initial parent population
    for (i <- 1 to 1000) {
      val letterMap = substitute.execute(cipher340)
      val fitness_score = fitness.execute(cipher340, letterMap)
      parents += (letterMap -> fitness_score)

    }
    
    // Create offspring from the initial population
    for (i <- 1 to 1000) {
      val child = crossover.execute(cipher340, parents)
      val fitness_score =  fitness.execute(cipher340, child)
      offspring += (child -> fitness_score)
    }

    val blendedGeneration = blender.execute(parents, offspring)
  }
}