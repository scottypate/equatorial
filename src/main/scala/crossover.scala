package com.scottypate.equatorial

import scala.util.Random
import scala.collection.mutable.ListBuffer

class Crossover() {

  val random = new Random()

  // Select a weighted sample from the population for a parent based on the fitness score of the solution
  def getParent(
      population: scala.collection.mutable.Map[Map[Char, String], Double]
  ) = {
    val keys = population.keySet
    val parent = keys.toVector(random.nextInt(keys.size))

    parent
  }

  // Produce a new possible solution by blending two parents together.
  def crossover(
      parentA: Map[Char, String],
      parentB: Map[Char, String],
      cipher: String
  ) = {
    val cipherList = cipher.toList.distinct
    var partialSolution = scala.collection.mutable.Map[Char, String]()
    for (letter <- cipherList) {
      val randomInt = random.nextInt(2)

      if (randomInt == 0) {
        partialSolution.put(letter, parentA(letter))
      } else if (randomInt == 1) {
        partialSolution.put(letter, parentB(letter))
      }
    }
    partialSolution
  }

  // Create a random mutation in one of the children at a given probability
  def mutate(
      childSolution: scala.collection.mutable.Map[Char, String],
      mutationProbability: Double
  ) = {
    val randomDouble = random.nextDouble()
    val randomIndex = random.nextInt(childSolution.size)
    if (randomDouble <= mutationProbability) {
      val randomMutation =
        Random.alphanumeric.filter(_.isLetter).head.toString.toLowerCase
      val randomKey =
        childSolution.get(childSolution.keySet.toVector(randomIndex)).toString
      childSolution.put(randomKey(0), randomMutation)
    }
    childSolution
  }
  def execute(
      cipher: String,
      population: scala.collection.mutable.Map[Map[Char, String], Double]
  ) = {
    val parentA = getParent(population)
    val parentB = getParent(population)
    val childSolution = crossover(parentA, parentB, cipher)
    val mutatedSolution = mutate(childSolution, 0.25)

    mutatedSolution.toMap
  }
}
