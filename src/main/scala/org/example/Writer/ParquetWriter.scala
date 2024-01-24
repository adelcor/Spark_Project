package org.example.Writer

import java.util.Properties
import org.apache.spark.sql.{Dataset, SaveMode}

/**
 * Object ParquetWriter provides functionality to write Spark datasets to different storage formats.
 *
 * It supports writing datasets to JDBC databases as well as to Parquet files.
 */
object ParquetWriter {

  /**
   * Writes a given dataset to a JDBC table.
   *
   * @param path       the JDBC URL to connect to the database
   * @param tablename  the name of the table where data will be written
   * @param dataset    the dataset to be written
   * @param properties the connection properties for JDBC (user, password, etc.)
   * @tparam T         the type parameter of the dataset
   */
  def writeToTable[T](path: String, tablename: String, dataset: Dataset[T])(implicit properties: Properties): Unit = {
    // Writing the dataset to the JDBC table with Append mode.
    dataset.write.mode(SaveMode.Overwrite).jdbc(path, tablename, properties)
  }

  /**
   * Writes a given dataset to a Parquet file.
   *
   * Parquet is a columnar storage format available in the Hadoop ecosystem.
   *
   * @param path    the path where the Parquet file will be written
   * @param dataset the dataset to be written
   * @tparam T      the type parameter of the dataset
   */
  def writeToParquet[T](path: String, dataset: Dataset[T]): Unit = {
    // Writing the dataset to a Parquet file.
    dataset.write.mode(SaveMode.Overwrite).parquet(path)
  }
}
