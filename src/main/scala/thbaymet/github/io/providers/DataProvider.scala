package thbaymet.github.io.providers

import thbaymet.github.io.models.{Agreement, Customer}

object DataProvider {

  def getCustomers: Seq[Customer] = {
    val customer0 = Customer("1", "John", "WICK", "1990-09-01")

    Seq(customer0)
  }

  def getAgreements: Seq[Agreement] = {
    val agreement0 = Agreement("1", "1", "2015-01-01", "2016-12-31")

    Seq(agreement0)
  }
}
