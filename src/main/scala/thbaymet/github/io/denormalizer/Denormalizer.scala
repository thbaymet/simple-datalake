package thbaymet.github.io.denormalizer

import org.apache.spark.sql.DataFrame

trait Denormalizer {

  /**
    * Implements default customer and agreement join logic.
    *
    * @param customer customer data frame
    * @param agreement agreement data frame
    * @return customer and agreement joined in a single data frame
    */
  def denormalize(customer: DataFrame, agreement: DataFrame): DataFrame = {
    val joinColumns = Seq("id")
    customer.join(agreement, joinColumns)
  }
}
