package thbaymet.github.io.extractor

class Regex {

  private val EMPTY_STRING = ""

  /**
    * Split a string by space and return them as a list
    */
  val splitter: String => List[String] = str => {
    str.trim.split("\\s").filter(_.nonEmpty).toList
  }

  val germanAddress: String => (String, String) = address => {
    splitter(address) match {
      case x:List[String] if x.length == 2 => (x.head, x.last)
      case x:List[String] if x.length >= 2 => (x.dropRight(1).mkString(" "), x.last)
      case _ => (address, EMPTY_STRING)
    }
  }

}
