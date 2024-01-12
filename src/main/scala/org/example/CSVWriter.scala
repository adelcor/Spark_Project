package org.example

import org.apache.spark.sql.{DataFrame, SparkSession}

object CSVWriter {
  def writeDataFrameToCSV(dataFrame: DataFrame, path: String): Unit = {
    dataFrame.write
      .option("header", "true")  // Para incluir la cabecera
      .csv(path)
  }
}
