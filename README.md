# Equatorial

![](https://github.com/scottypate/equatorial/workflows/Equatorial%20CI/badge.svg)

### Genetic Search algorithm for solving Zodiac 340 cipher

The Zodiac 340 cipher is an unsolved cipher that was produced by the Zodiac killer. This attempt is to solve the cipher using random solutions with selection pressure applied through a [fitness function](https://en.wikipedia.org/wiki/Genetic_algorithm). Previous work that has been done to apply genetic algorithms to this problem have used a fitness function that requires complete word matches. We know that the person that wrote the Zodiac ciphers was a poor speller. This fitness functions uses a probability like number of the text's match to the english language. This is done using the `LanguageDetection` [object](https://tika.apache.org/1.20/api/org/apache/tika/language/detect/LanguageDetector.html) of the [Apache Tika](https://tika.apache.org/) library. 

The app will prompt you to input the number of solutions generated in the initial population as well as the number of generations to run the evolution.

This application can be run locally or through the provided docker container. Since the app depends on user input, the docker command to run it is

`docker-compose up`

# License

See [LICENSE](LICENSE.md) file for rights and limitations (GNU GPL v3).