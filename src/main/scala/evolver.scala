class Evolver() {

  def execute(
    initial_population: scala.collection.mutable.Map[Map[Char, String], Double], 
    n_generations: Int, 
    n_children: Int,
    cipher: String ) = {

    val crossover = new Crossover()
    val evaluator = new Evaluator()
    val blender = new Blender()
    val sampler = new Sampler()

    var generation = initial_population

    for (i <- 1 to n_generations) {
      // Create offspring from the initial population
      val offspring = scala.collection.mutable.Map[Map[Char, String], Double]()
      // Get CDF of fitness values from the current population
      val sampleWeights = sampler.execute(generation)
      
      for (i <- 1 to n_children) {
        val child = crossover.execute(cipher, generation)
        val fitness_score =  evaluator.execute(cipher, child)
        offspring += (child -> fitness_score)
      }
      generation = blender.execute(generation, offspring)
      println("The best score for generation " + i + " is: " + generation.valuesIterator.max)
    }
    // Return the most fit solution from the evolution process 
    generation.maxBy(_._2)
  }
}