package thbaymet.github.io.txtfiles

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object TxtFiles extends scala.App {

  val spark = SparkSession
    .builder()
    .appName("TxtFiles")
    .master("local")
    .enableHiveSupport()
    .getOrCreate()

  spark.conf.getAll.foreach(println)

  val txtFilesPath = "txtfiles/*.txt"

  val txtFiles: RDD[(String, String)] = spark.sparkContext.wholeTextFiles(txtFilesPath)

  val fileContentSplit: RDD[(String, Array[Array[String]])] = txtFiles.map{
    case (file, wholeContent) =>
      (file, wholeContent.split("""\n\n""").map(_.split("""\n""")))
  }

  fileContentSplit.foreach{
    case (file, content) =>
      println("content: " + content.toList)
  }

//  fileContentSplit.foreach{
//    case (file, content) => println("content : " + content)
//  }
//
//
//  txtFiles.foreach{
//    case (file, content) => {
//      println(file + " ::: ")
//      content.split("\r\n").foreach(println(":::", _))
//    }
//  }

//  val txtFilesDF = txtFiles
//    .map{
//      case (file, content) => content.split("\r\n")
//    }
//    .toDF()
//
//  txtFilesDF.printSchema()
//  txtFilesDF.show()
}
