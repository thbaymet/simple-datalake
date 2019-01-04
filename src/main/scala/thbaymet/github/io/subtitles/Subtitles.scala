package thbaymet.github.io.subtitles

import org.apache.spark.sql.SparkSession

object Subtitles extends scala.App {
  val spark = SparkSession
    .builder()
    .appName("Subtitle")
    .master("local")
    .enableHiveSupport()
    .getOrCreate()

  spark.conf.getAll.foreach(println)

  val pathToSubtitleFile = "data/john_wick_chapter2.srt"

  val dfSubtitle = spark.sparkContext.textFile(pathToSubtitleFile)
  val counts = dfSubtitle
    .flatMap(line => line.split(" "))
    .map(_.replaceAll("""[\p{Punct}&&[^']]""", ""))
    .filter(word => """[A-Za-z]""".r.findFirstIn(word).isDefined)
    .map(word => (word, 1))
    .reduceByKey(_ + _)

  counts.repartition(5).saveAsTextFile("data/word_count")
}
