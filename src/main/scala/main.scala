object Main {
	
    def main(args: Array[String]) {
        val getter = new Getter()

        val cipher408 = getter.execute(
      	  appDir = System.getProperty("user.dir"),
      	  filename = "zodiac_408.txt"
        )

        val cipher340 = getter.execute(
      	  appDir = System.getProperty("user.dir"),
      	  filename = "zodiac_340.txt"
        )

        val substitute = new Substitute()
        val solution = substitute.execute(cipher340)

        val fitness = new Fitness()
        val fitness_score = fitness.execute(solution)
    }
}