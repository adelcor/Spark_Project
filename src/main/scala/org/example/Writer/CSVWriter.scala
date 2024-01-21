package org.example.Writer

import org.apache.spark.sql.DataFrame
import org.example.constants.Exampleconst

object CSVWriter {
  def writeToCSV(path: String,dataFrame: DataFrame): Unit = {

    dataFrame.write
      .option("header", "true")  // Para incluir la cabecera
      .csv(path)
  }
}
