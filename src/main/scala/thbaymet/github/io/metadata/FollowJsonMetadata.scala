package thbaymet.github.io.metadata

import thbaymet.github.io.commons.LocalSparkSession

object FollowJsonMetadata extends LocalSparkSession with scala.App {

  println("Hello")

  spark.conf.getAll.foreach(println)

}
