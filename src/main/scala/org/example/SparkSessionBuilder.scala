package org.example
import org.apache.spark.sql.SparkSession
object SparkSessionBuilder {
  def initializeSparkSession(appName: String): SparkSession = {
    SparkSession.builder()
      .appName(appName)
      .master("local[*]")
      .getOrCreate()
  }
}
