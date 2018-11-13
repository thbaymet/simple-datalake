package thbaymet.github.io

import org.apache.spark.sql.SparkSession
import thbaymet.github.io.models._

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

//  DataProvider.fetchUserData()

  import spark.implicits._
  val data = spark.read.json("data/customers.json").as[User]

  data.show
  data.printSchema()

  val americans = data.filter(_.isAmerican)
  americans.explain()
  println(americans.count())

  val females = data.filter(!_.isMale)
  println(females.count())



}
