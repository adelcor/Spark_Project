package org.example
import org.apache.spark.sql.{DataFrame, SparkSession}

import java.util.Properties

object DatabaseReader {
  def readDatabaseTable(implicit spark: SparkSession): DataFrame = {
    val properties = ConnectionPropertiesSetter.getConnectionProperties

    spark.read.jdbc(Exampleconst.url, Exampleconst.tableName, properties)
  }
}
