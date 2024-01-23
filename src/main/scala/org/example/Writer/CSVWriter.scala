package org.example.Writer

import org.apache.spark.sql.DataFrame
import org.example.constants.Exampleconst

/**
 * Object to handle the writing of data frames to CSV format.
 */
object CSVWriter {

  /**
   * Writes the given DataFrame to a CSV file at the specified path.
   *
   * This method writes the DataFrame to a CSV file, including headers.
   * The headers correspond to the column names of the DataFrame.
   *
   * @param path The file system path where the CSV file will be written.
   * @param dataFrame The DataFrame to be written to CSV format.
   */
  def writeToCSV(path: String, dataFrame: DataFrame): Unit = {
    // Ensuring that the header is written along with data
    dataFrame.write
      .option("header", "true") // Including the header for better readability of CSV
      .csv(path) // Writing the DataFrame to the specified path in CSV format
  }
}
