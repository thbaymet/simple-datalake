package thbaymet.github.io.udfs

import thbaymet.github.io.commons.LocalSparkSession
import org.apache.spark.sql.functions._

object SparkSqlUdfs extends scala.App with LocalSparkSession {

  import spark.implicits._

  val data = Seq("John")
  val schema = Seq("name")

  val df = spark.sparkContext.parallelize(data).toDF(schema :_ *)

  df.printSchema()
  df.show()

  val dfs = df
    .withColumn("col", col("name"))
    .withColumn("column", column("name"))
    .withColumn("lit", lit("literal"))
    .withColumn("trim", trim(col("name")))
    .withColumn("ltrim", ltrim(col("name")))
    .withColumn("rtrim", rtrim(col("name")))
    .withColumn("lower", lower(col("name")))
    .withColumn("upper", upper(col("name")))
    .withColumn("current_date", current_date())
    .withColumn("current_timestamp", current_timestamp())
    .withColumn("custom_date", lit("2019/02/22"))
    .withColumn("to_date", to_date(col("current_timestamp")))
    .withColumn("to_date/fmt", to_date(col("custom_date"), "yyyy/MM/dd"))

  dfs.printSchema()
  dfs.show()
}
