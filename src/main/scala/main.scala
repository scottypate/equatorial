object Main {
	
    def main(args: Array[String]) {
        val getter = new Getter()
        val substitute = new Substitute()
        val fitness = new Fitness()

        val cipher408 = getter.execute(
      	  appDir = System.getProperty("user.dir"),
      	  filename = "zodiac_408.txt"
        )

        val cipher340 = getter.execute(
      	  appDir = System.getProperty("user.dir"),
      	  filename = "zodiac_340.txt"
        )

        for (i <- 1 to 1000000) {
          val solution = substitute.execute(cipher340)
          val fitness_score = fitness.execute(solution)
        }
    }
}