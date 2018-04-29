import scala.util.Random

class Crossover(){

	def get_parent(population: scala.collection.mutable.Map[Map[Char, String], Double]) = {

	  val random = new Random();
    val keys = population.keySet
    val parent = keys.toVector(random.nextInt(keys.size))
    
    parent
	}

	def crossover(parentA: String, parentB: String) = {

  }

	def mutate(parentA: String, parentB: String) = {

  }

	def execute(population: scala.collection.mutable.Map[Map[Char, String], Double]) = {
    val parentA = get_parent(population)
    val parentB = get_parent(population)
	}
}