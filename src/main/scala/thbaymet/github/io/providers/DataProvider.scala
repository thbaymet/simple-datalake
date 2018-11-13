package thbaymet.github.io.providers

import java.io.{File, PrintWriter}

object DataProvider {

  /**
    * Fetch an external random user generator api
    * and store result in a CSV
    */
  def fetchUserData(): Unit = {
    val url = "https://randomuser.me/api/?format=JSON&results=100&nat=us,gb&noinfo"
    val data = scala.io.Source.fromURL(url).mkString
      .replace("{\"results\":", "").dropRight(1)
    val pw = new PrintWriter(new File("data/customers.json" ))
    pw.write(data)
    pw.close()
  }
}
