package org.example.DataSetUtilities

import org.apache.spark.sql.{Dataset, SparkSession}
import org.example.Logger.Logging
import scala.reflect.ClassTag
import org.apache.spark.sql.Encoders

/**
 * Object to load datasets in various formats using Apache Spark.
 *
 * Provides methods to load datasets from CSV and Parquet files.
 */
object DataSetLoader extends Logging {

  /**
   * Loads a Dataset from a CSV file.
   *
   * @param path The file path to the CSV file.
   * @param spark Implicit SparkSession required for Dataset operations.
   * @param ctag Implicit ClassTag of the type parameter, used for runtime reflection.
   * @tparam T The type of the elements in the Dataset.
   * @return A Dataset of type T.
   */
  def LoadCSVDataSet[T](path: String)(implicit spark: SparkSession, ctag: ClassTag[T]): Dataset[T] = {
    // Reading the CSV file with options to infer schema and use the first row as header
    spark.read
      .option("inferSchema", "true")
      .option("header", "true")
      .csv(path)
      // Converting the DataFrame to a Dataset of type T using an encoder derived from ClassTag
      .as[T](Encoders.bean(ctag.runtimeClass.asInstanceOf[Class[T]]))
  }

  /**
   * Loads a Dataset from a Parquet file.
   *
   * @param path The file path to the Parquet file.
   * @param spark Implicit SparkSession required for Dataset operations.
   * @param ctag Implicit ClassTag of the type parameter, used for runtime reflection.
   * @tparam T The type of the elements in the Dataset.
   * @return A Dataset of type T.
   */
  def LoadParquetDataSet[T](path: String)(implicit spark: SparkSession, ctag: ClassTag[T]): Dataset[T] = {
    // Reading the Parquet file
    spark.read
      .parquet(path)
      // Converting the DataFrame to a Dataset of type T using an encoder derived from ClassTag
      .as[T](Encoders.bean(ctag.runtimeClass.asInstanceOf[Class[T]]))
  }
}

