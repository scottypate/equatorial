package com.scottypate.equatorial

import scala.collection.immutable.ListMap

class Initializer() {

  def execute(
      cipher: String,
      nPopulation: Int,
      wordBag: Map[String, Int],
      proportionMap: scala.collection.mutable.Map[Char, Int]
  ) = {

    val utils = new Utils()
    val evaluator = new Evaluator()

    val initialPopulation =
      scala.collection.mutable.Map[Map[Char, String], Double]()
    // Create the initial parent population
    var iter = 0
    for (i <- 1 to nPopulation) {
      val solution = utils.substitute(cipher, proportionMap)
      val fitnessScore = evaluator.execute(cipher, solution, wordBag)
      initialPopulation += (solution -> fitnessScore)
      println(iter)
      iter += 1
    }
    initialPopulation
  }
}
