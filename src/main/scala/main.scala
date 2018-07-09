import scala.collection.immutable.ListMap

object Main {
    
  def main(args: Array[String]) {

    val getter = new Getter()
    val intializer = new Initializer()
    val evolver = new Evolver()

    val cipher408 = getter.execute(
      appDir = System.getProperty("user.dir"),
      filename = "zodiac_408.txt"
    )

    val cipher340 = getter.execute(
      appDir = System.getProperty("user.dir"),
      filename = "zodiac_340.txt"
    )

    val initial_population = intializer.execute(
      cipher = cipher340,
      n_population = 100000
    )

    val best_solution = evolver.execute(
      initial_population = initial_population,
      n_generations = 1000, 
      n_children = initial_population.size,
      cipher = cipher340
    )
    println("The best solution found at the end of evolution is:")
    println(best_solution)
  }
}