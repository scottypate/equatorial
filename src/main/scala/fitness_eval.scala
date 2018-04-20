class Fitness(){

	val commonBigrams = Array[String](
      "TH", "HE", "IN", "ER", "AN", "RE", "ON", "AT", "EN", "ND",
      "TI", "ES", "OR", "TE", "OF", "ED", "IS", "IT", "AL", "AR", 
      "ST", "NT", "TO"
	)

	def countBigrams(solution: String) = {

		var count = 0
        for (v <- commonBigrams) {
           val ind = solution contains v
           if (ind) {
             count += 1
             println(ind)
           }
        }
        count
	}

    def execute(solution: String) = {

    	val n_bigrams = countBigrams(solution)
    	n_bigrams
    }
}