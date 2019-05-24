import scala.collection.immutable.ListMap

class Initializer() {

  def execute(cipher: String, nPopulation: Int, wordBag: Map[String, Int]) = {

    val utils = new Utils()
    val evaluator = new Evaluator()

    val initialPopulation = scala.collection.mutable.Map[Map[Char, String], Double]()

    // Create the initial parent population
    while (initialPopulation.size < nPopulation){
      val solution = utils.substitute(cipher)
      val fitnessScore = evaluator.execute(cipher, solution, wordBag)
      val languageDetectionScore = evaluator.languageDetectionScore(
        utils.mapToString(letterMap=solution, cipher=cipher)
      )

      if (languageDetectionScore > 0.0){
        initialPopulation += (solution -> fitnessScore)
      }
    }
    initialPopulation
  }
}