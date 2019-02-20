package thbaymet.github.io.metadata

import org.apache.spark.sql.functions._
import thbaymet.github.io.commons.LocalSparkSession
import thbaymet.github.io.sql.UDFs

object FollowJsonMetadata extends LocalSparkSession with scala.App {

  println("Hello")

  spark.conf.getAll.foreach(println)

  private val pathToJsonMetadata = "/metadata.json"

  /**
    * Read json meta file and convert it to meta data
    */
  val metaHandler = new MetaHandler(pathToJsonMetadata)
  metaHandler.metadata.columns.foreach(col => println(col.method))

  /**
    * Read customers data from json file
    */
  var data = spark.read.json("data/customers.json")
  data.show()

  /**
    * Register user defined custom functions
    */
  spark.sqlContext.udf.register("columnSplit", UDFs.columnSplit)

  /**
    * Apply/Transform each column definitions in json meta data
    */
  metaHandler.metadata.columns.foreach{col =>
    data = data.withColumn(col.toColumn, expr(col.method))
  }

  data.show()
}
