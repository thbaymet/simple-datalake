package thbaymet.github.io.hdfs

import scala.collection.mutable

object TransactionFiles {

  val fileProcessStack: mutable.Map[String, String] = mutable.Map[String, String]()

  def markAsRejectedFile(fileName: String, cause: String): Boolean = {
    // TODO: if file exists then
    // fileProcessStack.put(fileName, FileHistoryStack("transaction", "rejected", cause)
    true
  }

}
