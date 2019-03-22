package thbaymet.github.io.extractor

import org.scalatest.FunSuite

class RegexTest extends FunSuite {

  val regex = new Regex

  test("splitter") {
    assert(regex.splitter(" Str.  134 ") == List("Str.", "134"))
  }

  test("testGermanAddress") {
    assert(regex.germanAddress(" Str.   134  ") == ("Str.", "134"))
    assert(regex.germanAddress("Lankwitzer Str. 134") == ("Lankwitzer Str.", "134"))
  }

}
