import scala.util.Random

class Substitute(){

    def execute(cipher: String) = {

    	var solution = cipher
        val cipherList = cipher.toList.distinct
        var letters = for (i <- 1 to cipherList.length) yield Random.alphanumeric.filter(_.isLetter).head.toString.toLowerCase
        val letterMap = (cipherList zip letters).toMap

        for ((k,v) <- letterMap){
        	solution = solution.replace(k, v.charAt(0))
        }
        solution
    }
}