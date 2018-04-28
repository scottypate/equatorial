import scala.util.Random

class Substitute(){

def execute(cipher: String) = {

    val cipherList = cipher.toList.distinct
    var letters = for (i <- 1 to cipherList.length) yield Random.alphanumeric.filter(_.isLetter).head.toString.toLowerCase
    val letterMap = (cipherList zip letters).toMap

    letterMap
  }
}