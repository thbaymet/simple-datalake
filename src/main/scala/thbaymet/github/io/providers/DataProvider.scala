package thbaymet.github.io.providers

import java.io.{File, PrintWriter}

import thbaymet.github.io.models.{Agreement, Customer}

object DataProvider {

  /**
    * Get a sequence of customer data object
    * @return Sequence of customer object
    */
  def getCustomers: Seq[Customer] = {
    fetchCustomerData()
    val customer0 = Customer("1", "John", "WICK", "1990-09-01")

    Seq(customer0)
  }

  /**
    * Get a sequence of agreement data object
    * @return Sequence of agreement data
    */
  def getAgreements: Seq[Agreement] = {
    val agreement0 = Agreement("1", "1", "2015-01-01", "2016-12-31")

    Seq(agreement0)
  }

  /**
    * Fetch an external random user generator api
    * and store result in a CSV
    */
  private def fetchCustomerData(): Unit = {
    val url = "https://randomuser.me/api/?format=CSV&results=100&nat=us,gb"
    val csvContent = scala.io.Source.fromURL(url).mkString
    val pw = new PrintWriter(new File("data/customers.csv" ))
    pw.write(csvContent)
    pw.close()
  }
}
