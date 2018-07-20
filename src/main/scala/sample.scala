import scala.util.Random

class Sampler(){

  val random = new Random()

  def execute(observations: scala.collection.mutable.Map[Map[Char, String], Double]) = {

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
}