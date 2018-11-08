package thbaymet.github.io

import org.scalatest.FunSuite

class SimpleDatalakeTest extends FunSuite {

  val simpleDatalake = new SimpleDatalake()

  test("test getProjectName") {
    assert(simpleDatalake.getProjectName
      .equalsIgnoreCase("SimpleDatalake"))
  }


}
