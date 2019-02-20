package thbaymet.github.io.metadata

import net.liftweb.json.{DefaultFormats, parse}
import thbaymet.github.io.metadata.entity.Columns

import scala.io.Source

class MetaHandler(metaFile: String) {

  private val jsonMetadataContent = getClass.getResourceAsStream(metaFile)

  private val jsonMetadataText = Source.fromInputStream(jsonMetadataContent).mkString

  implicit val formats: DefaultFormats.type = DefaultFormats

  val metadata: Columns = parse(jsonMetadataText).extract[Columns]

}
