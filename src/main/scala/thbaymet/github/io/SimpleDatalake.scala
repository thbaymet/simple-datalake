package thbaymet.github.io

import org.apache.spark.sql.SparkSession
import thbaymet.github.io.providers.DataProvider

class SimpleDatalake {
  val getProjectName: String = "SimpleDatalake"

}

object SimpleDatalake extends scala.App {
  println("Welcome to SimpleDatalake project.")

  val spark = SparkSession
    .builder()
    .appName("SimpleDatalake")
    .master("local")
    .getOrCreate()

  spark.conf.getAll.foreach(println)

  val customers = DataProvider.getCustomers
  customers.foreach(println)

  val agreements = DataProvider.getAgreements
  agreements.foreach(println)

}
