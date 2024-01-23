package org.example.Reader

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.example.Connect.ConnectionPropertiesSetter
import org.example.constants.Exampleconst

/**
 * Object for reading data from a database.
 *
 * This object provides functionality to connect to a database and read data from a specified table.
 * It uses Apache Spark's DataFrame API for handling the data.
 */
object DatabaseReader {

  /**
   * Reads a table from the database and returns it as a DataFrame.
   *
   * This method establishes a JDBC connection to the database using connection properties
   * defined in `ConnectionPropertiesSetter`. It then reads the specified table into a DataFrame.
   *
   * @param tableName The name of the table to be read from the database.
   * @param spark Implicit SparkSession that provides the context for DataFrame operations.
   * @return DataFrame representing the data from the specified table.
   */
  def readTable(tableName: String)(implicit spark: SparkSession): DataFrame = {
    // Retrieve connection properties for the database
    val properties = ConnectionPropertiesSetter.getConnectionProperties

    // Read the table into a DataFrame using JDBC and return it
    spark.read.jdbc(Exampleconst.url, tableName, properties)
  }
}
