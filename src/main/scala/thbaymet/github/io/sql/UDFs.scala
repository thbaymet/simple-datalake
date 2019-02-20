package thbaymet.github.io.sql

object UDFs {

  /**
    * Custom split function
    */
  val columnSplit: (String, String) => String = (column, delimiter) => {
    val split = column.split(delimiter)
    if (split.lengthCompare(0) > 1) {
      split(0)
    } else {
      ""
    }
  }
}
