package thbaymet.github.io.columns

import thbaymet.github.io.commons.LocalSparkSession

object ColumnTester extends scala.App with LocalSparkSession {

  /**
    * Read customers data from json file
    */
  var data = spark.read.json("data/customers.json")
  data.show()
}
