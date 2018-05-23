class Fitness(){

  val commonBigrams = Array[String](
    "TH", "HE", "IN", "ER", "AN", "RE", "ON", "AT", "EN", "ND",
    "TI", "ES", "OR", "TE", "OF", "ED", "IS", "IT", "AL", "AR", 
    "ST", "NT", "TO", "LL", "IL", "OU", "EA", "HI", "AS", "TE"
  )

  val commonTrigrams = Array[String](
    "THE", "ERE", "HES", "AND", "TIO", "VER", "ING", "TER", "HIS",
    "ENT", "EST", "OFT", "ION", "ERS", "ITH", "HER", "ATI", "FTH",
    "FOR", "HAT", "STH", "THA", "ATE", "OTH", "NTH", "ALL", "RES",
    "INT", "ETH", "ONT"
  )

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
         println(ind)
       }
    }
    count.toFloat / (solution.length - 2)
  }

  def countTrigrams(solution: String) = {

    var count = 0
    for (v <- commonTrigrams) {
      val ind = solution contains v
      if (ind) {
        count += 1
        println(ind)
      }
    }
    count.toFloat / (solution.length - 3)
  }

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

  def execute(cipher: String, letterMap: Map[Char, String]) = {
    var solution = cipher

    for ((k,v) <- letterMap){
      solution = solution.replace(k, v.charAt(0))
    }

    val nBigrams = countBigrams(solution)
    val nTrigrams = countBigrams(solution)
    val frequencyScore = letterFrequencyScore(solution)
    frequencyScore + nBigrams + nTrigrams
  }
}