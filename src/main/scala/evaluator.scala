package com.scottypate.equatorial

import scala.math._
import org.apache.tika.langdetect.OptimaizeLangDetector
import scala.collection.JavaConverters._

// This class contains various methods for evaluating the solution's fitness
class Evaluator() {

  val language = new OptimaizeLangDetector()
  val utils = new Utils()

  def languageDetectionScore(solution: String) = {
    language.loadModels()
    val languageResult = asScalaBuffer(language.detectAll(solution))
    var returnScore = 0.0f
    for (result <- languageResult) {
      if (result.getLanguage() == "en") {
        returnScore = result.getRawScore()
      }
    }
    returnScore
  }

  def score_solution(solution: String, wordBag: Map[String, Int]) = {

    var score = 0.0

    for ((k, v) <- wordBag) {
      if (solution.contains(k)) {
        score += 1 * exp(k.length.toDouble)
      }
    }
    score
  }

  def execute(
      cipher: String,
      letterMap: Map[Char, String],
      wordBag: Map[String, Int]
  ) = {
    var solution = utils.mapToString(letterMap, cipher)
    score_solution(solution, wordBag)
  }
}
