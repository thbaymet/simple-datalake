package thbaymet.github.io.commons

import org.apache.spark.sql.SparkSession

trait LocalSparkSession {

  private val applicationName = "Simple DataLake"

  private val sparkMasterURL = "local[*]"

  val spark: SparkSession = SparkSession.builder()
    .appName(applicationName)
    .master(sparkMasterURL)
    .enableHiveSupport()
    .getOrCreate()
}
