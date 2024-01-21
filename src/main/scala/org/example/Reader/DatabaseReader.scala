package org.example.Reader

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.example.Connect.ConnectionPropertiesSetter
import org.example.constants.Exampleconst

object DatabaseReader {
  def readTable(tableName: String)(implicit spark: SparkSession): DataFrame = {
    val properties = ConnectionPropertiesSetter.getConnectionProperties

    spark.read.jdbc(Exampleconst.url, tableName, properties)
  }
}
