import org.apache.tika.langdetect.Lingo24LangDetector
import scala.collection.JavaConverters
import scala.collection.mutable.Set


class language(){
	def execute() = {
		val language = new Lingo24LangDetector()
		println(language.isAvailable())
		language.loadModels()
		println(language.detect("I think this is english"))
	}
}

