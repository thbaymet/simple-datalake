package thbaymet.github.io.columns

import org.apache.spark.sql.Column
import org.apache.spark.sql.catalyst.expressions.Expression

object DColumn {
  def apply(expr: Expression): DColumn = new DColumn(expr)
}

class DColumn(expr: Expression) extends Column(expr) {

}
