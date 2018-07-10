import scala.util.Random

class Substitute(){

  def execute(cipher: String) = {

      val cipherList = cipher.toList.distinct
      var letters = for (i <- 1 to cipherList.length) yield Random.alphanumeric.filter(_.isLetter).head.toString.toLowerCase
      val letterMap = (cipherList zip letters).toMap

      letterMap
  }

  def map_to_string(letterMap: Map[Char, String], cipher: String) = {
    
    var solution = cipher

    for ((k,v) <- letterMap){
      solution = solution.replace(k, v.charAt(0))
    }
    solution
  }

}