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
    .enableHiveSupport()
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

  /**
    * Save data in a table
    */
  val tableName = "io_customers"
  spark.sql(s"drop table if exists $tableName")
  data.write.format("parquet").saveAsTable(tableName)

  /**
    * Explore the table
    */
  val table = spark.table(tableName)
  table.printSchema()

  val columnsToShow = Seq("name.first", "email", "gender", "dob.age",
    "location.city")

  table.selectExpr(columnsToShow :_ *).show()
}
