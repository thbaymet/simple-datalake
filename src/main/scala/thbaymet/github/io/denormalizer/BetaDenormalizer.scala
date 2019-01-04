package thbaymet.github.io.denormalizer
import org.apache.spark.sql.DataFrame

class BetaDenormalizer extends Denormalizer {

  /**
    * BetaDenormalizer should override default denormalize method for some
    * reasons.
    *
    * @param customer customer data frame
    * @param agreement agreement data frame
    * @return customer and agreement joined in a single data frame
    */
  override def denormalize(customer: DataFrame, agreement: DataFrame)
  : DataFrame = {

    /**
      * Will add Beta Denormalizer logic before join
      */

    super.denormalize(customer, agreement)
  }

}
