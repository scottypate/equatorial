package com.scottypate.equatorial

import scala.collection.immutable.ListMap
import java.io.File
import scala.collection.mutable.StringBuilder

object Main {

  def main(args: Array[String]) {

    val utils = new Utils()
    val intializer = new Initializer()
    val evolver = new Evolver()
    val evaluator = new Evaluator()

    val appDir = System.getProperty("user.dir")

    val cipher408 = utils.getFile(
      dir = appDir,
      filename = "/data/ciphers/zodiac_408.txt"
    )

    val cipher340 = utils.getFile(
      dir = appDir,
      filename = "/data/ciphers/zodiac_340.txt"
    )

    val testCipher = utils.getFile(
      dir = appDir,
      filename = "/data/ciphers/test.txt"
    )

    val cipher408Solution = utils.getFile(
      dir = appDir,
      filename = "/data/ciphers/zodiac_408_solution.txt"
    )

    var allLetters = new StringBuilder()

    val files = utils.getListOfFiles(appDir + "/data/letters/")
    for (file <- files) {
      allLetters.append(utils.getFile(filename = file.toString()))
    }

    // Remove all punctuation, https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
    val cleanedLetters =
      allLetters.toString.replaceAll("""[\p{Punct}&&[^.]]""", " ")

    val proportionMap = utils.proportionMap(cleanedLetters, cipher340)
    val wordBag = utils.createWordBag(cleanedLetters)

    // This gives some idea of what the fitness score looks like for a solved cipher
    val cipher408fitness = evaluator.score_solution(cipher408Solution, wordBag)
    println("The fitness score for the 408 solution is: " + cipher408fitness)

    print("How many members of the initial population?  ")
    val nPopulation = scala.io.StdIn.readInt()

    print("How many generations to evolve?  ")
    val nGenerations = scala.io.StdIn.readInt()

    val initial_population = intializer.execute(
      cipher = cipher340,
      nPopulation = nPopulation,
      wordBag = wordBag,
      proportionMap = proportionMap
    )
    val cdf = utils.sample(initial_population)

    println(
      "Running the evolution for " + nPopulation + " populations and " + nGenerations + " generations."
    )
    evolver.execute(
      initialPopulation = initial_population,
      nGenerations = nGenerations,
      nChildren = initial_population.size,
      cipher = cipher340,
      wordBag = wordBag,
      proportionMap = proportionMap
    )
  }
}
