package org.example
import org.apache.spark.sql.{DataFrame, SparkSession}

import java.util.Properties

object DatabaseReader {
  def readDatabaseTable(spark: SparkSession, url: String, table: String, properties: Properties): DataFrame = {
    spark.read.jdbc(url, table, properties)
  }
}
