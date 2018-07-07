import scala.collection.immutable.ListMap

class Initializer() {

  def execute(cipher: String, n_population: Int) = {

    val substitute = new Substitute()
    val evaluator = new Evaluator()

    val initial_population = scala.collection.mutable.Map[Map[Char, String], Double]()

    // Create the initial parent population
    for (i <- 1 to 10000) {
      val letterMap = substitute.execute(cipher)
      val fitness_score = evaluator.execute(cipher, letterMap)
      initial_population += (letterMap -> fitness_score)
    }
    initial_population
  }
}