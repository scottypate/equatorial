import scala.collection.immutable.ListMap

object Main {
    
  def main(args: Array[String]) {

    val language = new language()
    language.execute()
    // val getter = new Getter()
    // val intializer = new Initializer()
    // val evolver = new Evolver()
    // val evaluator = new Evaluator()
    // val sampler = new Sampler()
    // val substitute = new Substitute()

    // val cipher408 = getter.execute(
    //   appDir = System.getProperty("user.dir"),
    //   filename = "zodiac_408.txt"
    // )

    // val cipher340 = getter.execute(
    //   appDir = System.getProperty("user.dir"),
    //   filename = "zodiac_340.txt"
    // )

    // val cipher408Solution = getter.execute(
    //   appDir = System.getProperty("user.dir"),
    //   filename = "zodiac_408_solution.txt"
    // )
    
    // val cipher408fitness = evaluator.score_solution(cipher408Solution)
    // println("The fitness score for the 408 solution is: " + cipher408fitness)

    // val initial_population = intializer.execute(
    //   cipher = cipher340,
    //   n_population = 50000
    // )
    // val cdf = sampler.execute(initial_population)

    // val best_solution = evolver.execute(
    //   initial_population = initial_population,
    //   n_generations = 30, 
    //   n_children = initial_population.size,
    //   cipher = cipher340
    // )
    // println("The best solution found at the end of evolution is:")
    // println(substitute.map_to_string(letterMap=best_solution._1, cipher=cipher340))
  }
}