package thbaymet.github.io.udfs

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.functions._
import thbaymet.github.io.commons.LocalSparkSession

object SparkSqlUdfs extends scala.App with LocalSparkSession {

  Logger.getRootLogger.setLevel(Level.WARN)

  import spark.implicits._

  val data = Seq("John", "Arnold", "Tom", "Xavier")
  val schema = Seq("name")

  val df = spark.sparkContext.parallelize(data).toDF(schema :_ *)

  df.printSchema()
  df.show()

  def randomNumber = udf(() => (Math.random * 100).toInt - 63)
  def nullValue = udf(() => if (Math.random * 100 > 85) null else "-")

  val dfs = df
    .withColumn("col", col("name"))
    .withColumn("column", column("name"))
    .withColumn("lit", lit("literal"))
    .withColumn("null", nullValue())
    .withColumn("trim", trim(col("name")))
    .withColumn("ltrim", ltrim(col("name")))
    .withColumn("rtrim", rtrim(col("name")))
    .withColumn("lower", lower(col("name")))
    .withColumn("upper", upper(col("name")))
    .withColumn("current_date", current_date())
    .withColumn("current_timestamp", current_timestamp())
    .withColumn("to_date", to_date(col("current_timestamp")))
    .withColumn("custom_date", lit("2019/02/22"))
    .withColumn("to_date/fmt", to_date(col("custom_date"), "yyyy/MM/dd"))
    .withColumn("random_number", randomNumber())
    .withColumn("abs_random_number", abs(randomNumber()))
    .withColumn("array", array("lit", "current_date"))
    .withColumn("coalesce", coalesce(col("null"), col("lit")))
    .withColumn("input_file_name", input_file_name())
    .withColumn("isnull", isnull(col("null")))
    .withColumn("isnan", isnan(col("null")))
    .withColumn("negate", negate(col("random_number")))
    .withColumn("negate1", -col("random_number"))
    .withColumn("not", not(col("isnull")))
    .withColumn("not1", !col("isnull"))
    .withColumn("rand", rand(1))
    .withColumn("rand1", rand())
    .withColumn("rand_n", randn(1))
    .withColumn("rand_n1", randn())
    .withColumn("spark_partition_id", spark_partition_id())
    .withColumn("sqrt", sqrt(abs(col("random_number"))))
    .withColumn("struct", struct(col("name"), col("col"), col("lower")))
    .withColumn("whenIsNull", when(col("null").isNull, "wasNull").otherwise("wasNotNull"))


  dfs.printSchema()
  dfs.show()
}
