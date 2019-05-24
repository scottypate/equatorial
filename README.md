[![CircleCI](https://circleci.com/gh/scottypate/equatorial/tree/master.svg?style=svg)](https://circleci.com/gh/scottypate/equatorial/tree/master)

# Equatorial

### Genetic Search algorithm for solving Zodiac 340 cipher

The Zodiac 340 cipher is an unsolved cipher that was produced by the Zodiac killer. This attempt is to solve the cipher using random solutions with selection pressure applied through a fitness function. Previous work that has been done to apply genetic algorithms to this problem have used a fitness function that requires complete word matches. We know that the person that wrote the Zodiac ciphers was a poor speller. This fitness functions uses a probability like number of the text's match to the english language. This is done using the `LanguageDetection` [object](https://tika.apache.org/1.20/api/org/apache/tika/language/detect/LanguageDetector.html) of the [Apache Tika](https://tika.apache.org/) library. 

# License

See [LICENSE](LICENSE.md) file for rights and limitations (GNU GPL v3).