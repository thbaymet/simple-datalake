package thbaymet.github.io.sql

import org.scalatest.FunSuite

class UDFsTest extends FunSuite {

  test("testColumnSplit") {
    assert(UDFs.columnSplit("william, bates, sanchez", ",") == "william")
    assert(UDFs.columnSplit("william, bates", ",") == "william")
    assert(UDFs.columnSplit("william", ",") == "")
  }

}
