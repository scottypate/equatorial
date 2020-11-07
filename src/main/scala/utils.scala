package com.scottypate.equatorial

import scala.util.Random
import scala.io.Source
import java.io.File
import scala.collection.mutable.ListMap

class Utils() {

	def mapToString(letterMap: Map[Char, String], cipher: String) = {
    
    var solution = cipher

    for ((k,v) <- letterMap){
      solution = solution.replace(k, v.charAt(0))
    }
    solution
  }

  def substitute(cipher: String) = {

	  val cipherList = cipher.toList.distinct
	  var letters = for (i <- 1 to cipherList.length) yield Random.alphanumeric.filter(_.isLetter).head.toString.toLowerCase
	  val letterMap = (cipherList zip letters).toMap

	  letterMap
  }

  def sample(observations: scala.collection.mutable.Map[Map[Char, String], Double]) = {
  	val random = new Random()
    var cdf = scala.collection.mutable.Map[Double, Double]()
    var runningSum: Double = 0.0

    var totalWeight: Double = observations.foldLeft(0.0)(_+_._2)
    val scores: List[Double] = observations.values.toList.sorted
    
    for (score <- scores){ 
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

    var blendedGeneration = ListMap((orderedParents.take(parentSize / 2) ++ orderedOffspring.take(parentSize / 2)):_*)
    
    blendedGeneration
  }
}