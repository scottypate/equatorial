import scala.io.Source

class Getter(){

  def execute(appDir: String, filename: String): String = {

    val bufferedSource = Source.fromFile(appDir + "/data/" + filename)
    var returnString: String = ""
    for (line <- bufferedSource.getLines) {
      returnString += line
    }
    bufferedSource.close

    returnString
  }
}