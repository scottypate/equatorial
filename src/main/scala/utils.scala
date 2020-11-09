package com.scottypate.equatorial

import scala.util.Random
import scala.math._
import scala.io.Source
import java.io.File
import scala.collection.mutable.ListMap
import scala.collection.mutable.ArrayBuffer

class Utils() {

  def mapToString(letterMap: Map[Char, String], cipher: String) = {

    var solution = cipher

    for ((k, v) <- letterMap) {
      solution = solution.replace(k, v.charAt(0))
    }
    solution
  }

  // The frequencyMap method returns a map of english letters and the proportion
  // by which they occur in the given cipher.
  def proportionMap(
      letters: String,
      cipher: String
  ): scala.collection.mutable.Map[Char, Int] = {
    var cleanedLetters: String = letters.replaceAll("[^a-zA-Z]", "")
    var frequencyMap = scala.collection.mutable.Map.empty[Char, Int]
    val cipherCharacters = cipher.distinct.length

    for (character <- cleanedLetters) {
      if (frequencyMap.contains(character))
        frequencyMap(character) = frequencyMap(character) + 1
      else
        frequencyMap.+=((character, 1))
    }
    val proportionMap = frequencyMap.map(kv =>
      (
        kv._1,
        math
          .ceil((kv._2.toFloat / cleanedLetters.length) * cipherCharacters)
          .toInt
      )
    )
    proportionMap
  }

  // The substitute method replaces values in the given cipher with english letters
  // from the given proportionMap.
  def substitute(
      cipher: String,
      proportionMap: scala.collection.mutable.Map[Char, Int]
  ) = {
    var proportionalAlphabet = ArrayBuffer[Char]()
    for ((k, v) <- proportionMap) {
      proportionalAlphabet = proportionalAlphabet ++ (k.toString * v).toArray
    }
    val cipherList = cipher.toList.distinct
    var letters =
      for (i <- 1 to cipherList.length) yield {
        val randomIndex = Random.nextInt(proportionalAlphabet.length)
        val randomLetter = proportionalAlphabet(randomIndex)
        proportionalAlphabet.remove(randomIndex)
        randomLetter.toString
      }
    val letterMap = (cipherList zip letters).toMap
    letterMap
  }

  def sample(
      observations: scala.collection.mutable.Map[Map[Char, String], Double]
  ) = {
    val random = new Random()
    var cdf = scala.collection.mutable.Map[Double, Double]()
    var runningSum: Double = 0.0

    var totalWeight: Double = observations.foldLeft(0.0)(_ + _._2)
    val scores: List[Double] = observations.values.toList.sorted

    for (score <- scores) {
      runningSum += (score / totalWeight)
      cdf += (score -> runningSum)
    }
    cdf
  }

  def getFile(dir: String = "", filename: String): String = {
    val returnString = Source.fromFile(dir + filename).getLines.mkString
    returnString
  }

  def createWordBag(text: String): Map[String, Int] = {
    text.split(" ").map(_.toLowerCase).groupBy(identity).mapValues(_.size).toMap
  }

  def getListOfFiles(dir: String): List[File] = {
    val directory = new File(dir)
    directory.listFiles.filter(_.isFile).toList
  }

  def blendGeneration(
      offspring: scala.collection.mutable.Map[Map[Char, String], Double],
      parents: scala.collection.mutable.Map[Map[Char, String], Double]
  ) = {

    val orderedParents = parents.toSeq.sortWith(_._2 > _._2)
    val orderedOffspring = offspring.toSeq.sortWith(_._2 > _._2)

    val parentSize = orderedParents.size

    var blendedGeneration = ListMap(
      (orderedParents.take(parentSize / 2) ++ orderedOffspring.take(
        parentSize / 2
      )): _*
    )

    blendedGeneration
  }
}
