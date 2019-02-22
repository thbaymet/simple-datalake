package thbaymet.github.io.hdfs

import thbaymet.github.io.hdfs.entity.FileHistoryStack

import scala.collection.mutable

object TransactionFiles {

  val fileProcessStack: mutable.Map[String, FileHistoryStack] = mutable.Map[String, FileHistoryStack]()

  /**
    * Mark a file as a rejected one and put it in the stack
    * @param fileName name of the file
    * @param cause reject reason
    * @return true if it is marked false if it was already marked
    */
  def markAsRejectedFile(fileName: String, cause: String): Boolean = {
    if (!fileProcessStack.contains(fileName)) {
      fileProcessStack.put(fileName, FileHistoryStack("transaction", "rejected", cause))
      true
    }
    else {
      false
    }
  }

}
