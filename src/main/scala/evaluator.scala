import collection.JavaConverters._
import org.apache.tika.langdetect.Lingo24LangDetector

// This class contains various methods for evaluating the solution's fitness
class Evaluator(){

  // Most common english bigrams
  val commonBigrams = Array[String](
    "th", "he", "in", "er", "an", "re", "on", "at", "en", "nd",
    "ti", "es", "or", "te", "of", "ed", "is", "it", "al", "ar", 
    "st", "nt", "to", "ll", "il", "ou", "ea", "hi", "as", "te",
    "my", "in", "of", "be", "ha", "et", "ng"
  )

  // Most common english trigrams
  val commonTrigrams = Array[String](
    "the", "ere", "hes", "and", "tio", "ver", "ing", "ter", "his",
    "ent", "est", "oft", "ion", "ers", "ith", "her", "ati", "fth",
    "for", "hat", "sth", "tha", "ate", "oth", "nth", "all", "res",
    "int", "eth", "ont", "ill", "you", "fun", "iti", "ebe",  "tha"
  )

  // English letter frequency of occurence
  var letterFrequencies = Map(
    "a" -> 0.08167,
    "b" -> 0.01492,
    "c" -> 0.02782,
    "d" -> 0.04253,
    "e" -> 0.02702,
    "f" -> 0.02228,
    "g" -> 0.02015,
    "h" -> 0.06094,
    "i" -> 0.06966,
    "j" -> 0.00153,
    "k" -> 0.00772,
    "l" -> 0.04025,
    "m" -> 0.02406,
    "n" -> 0.06749,
    "o" -> 0.07507,
    "p" -> 0.01929,
    "q" -> 0.00095,
    "r" -> 0.05987,
    "s" -> 0.06327,
    "t" -> 0.09056,
    "u" -> 0.02758,
    "v" -> 0.00978,
    "w" -> 0.02360,
    "x" -> 0.00150,
    "y" -> 0.01974,
    "z" -> 0.00074
  )

  def countBigrams(solution: String) = {

    var count = 0
    for (v <- commonBigrams) {
       val ind = solution contains v
       if (ind) {
         count += 1
       }
    }
    count
  }

  def countTrigrams(solution: String) = {

    var count = 0
    for (v <- commonTrigrams) {
      val ind = solution contains v
      if (ind) {
        count += 1
      }
    }
    count
  }

  // How far does the solution deviate from english letter frequencies
  def letterFrequencyScore(solution: String) = {
    var sum: Integer = solution.size
    var solutionFrequencies = solution.groupBy(identity).mapValues(_.size.toFloat / sum)
    var score: Double = 0.0

    for ((letter, frequency) <- letterFrequencies) {
      if (solution contains letter){
        score += Math.abs(solutionFrequencies(letter.charAt(0)) - frequency)
      }
      else {
        score += frequency
      }
    }
    score
  }

  def languageDetectionScore(solution: String) = {
    val language = new Lingo24LangDetector()
    language.loadModels()
    val languageResult = asScalaBuffer(language.detectAll(solution))
    var returnScore = 0.0f
    for (result <- languageResult) {
      if (result.getLanguage() == "en") {
        returnScore = result.getRawScore()
      }
    }
    println(returnScore)
  }

  def score_solution(solution: String) = {
    val score = languageDetectionScore(solution)
    score
  }

  def execute(cipher: String, letterMap: Map[Char, String]) = {
    var solution = cipher

    for ((k,v) <- letterMap){
      solution = solution.replace(k, v.charAt(0))
    }
    score_solution(solution)
  }
}