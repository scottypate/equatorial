package com.scottypate.equatorial

class Evolver() {

  def execute(
      initialPopulation: scala.collection.mutable.Map[Map[
        Char,
        String
      ], Double],
      nGenerations: Int,
      nChildren: Int,
      cipher: String,
      wordBag: Map[String, Int]
  ) = {

    val crossover = new Crossover()
    val evaluator = new Evaluator()
    val utils = new Utils()

    var generation = initialPopulation
    var solutions = Array[String]()
    var nAttempts = nChildren

    for (i <- 1 to nGenerations) {
      // Create offspring from the initial population
      val offspring = scala.collection.mutable.Map[Map[Char, String], Double]()
      // Get CDF of fitness values from the current population
      val sampleWeights = utils.sample(generation)
      var iter = 0
      for (i <- 1 to nAttempts) {
        val childMap = crossover.execute(cipher, generation)
        val fitnessScore = evaluator.execute(cipher, childMap, wordBag)
        offspring += (childMap -> fitnessScore)
      }
      generation = utils.blendGeneration(generation, offspring)
      val bestSolution = generation.maxBy(_._2)
      solutions :+ bestSolution
      println("The best score for generation " + i + " is: " + bestSolution._2)
      println(
        "Solution: " + utils.mapToString(
          letterMap = bestSolution._1,
          cipher = cipher
        )
      )
    }
  }
}
