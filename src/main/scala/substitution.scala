import scala.util.Random

class Substitute(){

    def execute(cipher: String) = {
        val cipher_list = cipher.toList.distinct
        var letters = for (i <- 1 to cipher.length) yield Random.alphanumeric.filter(_.isLetter).head.toString.toLowerCase
        println(letters)
    }
}