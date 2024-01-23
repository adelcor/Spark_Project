package org.example.Layers

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.example.Logger.Logging
import org.example.Reader.DatabaseReader
import org.example.Writer.CSVWriter
import org.example.constants.Exampleconst

/**
 * The BronzeLayer object is responsible for processing data at the bronze layer.
 * It involves reading data from database tables and writing it to CSV files.
 *
 * @note The bronze layer is typically used for raw data ingestion.
 */
object BronzeLayer extends Logging {

  /**
   * Processes the bronze layer by reading data from database tables and writing it to CSV files.
   *
   * @param spark Implicit SparkSession to be used for data processing.
   */
  def processBronzeLayer(implicit spark: SparkSession): Unit = {
    logger.info("Reading data from the database tables")

    // Reading data from each table
    val dfCliente: DataFrame = DatabaseReader.readTable(Exampleconst.tableCliente)
    val dfPedido: DataFrame = DatabaseReader.readTable(Exampleconst.tablePedido)
    val dfProducto: DataFrame = DatabaseReader.readTable(Exampleconst.tableProducto)
    val dfProveedor: DataFrame = DatabaseReader.readTable(Exampleconst.tableProveedor)

    logger.info("Showing the first few records of each DataFrame")

    // Displaying the first few records of each DataFrame
    dfCliente.show()
    dfPedido.show()
    dfProducto.show()
    dfProveedor.show()

    logger.info(s"Writing DataFrame to CSV in the path ${Exampleconst.pathCliente}")

    // Writing each DataFrame to a CSV file
    CSVWriter.writeToCSV(Exampleconst.pathCliente, dfCliente)
    CSVWriter.writeToCSV(Exampleconst.pathPedido, dfPedido)
    CSVWriter.writeToCSV(Exampleconst.pathProducto, dfProducto)
    CSVWriter.writeToCSV(Exampleconst.pathProveedor, dfProveedor)
  }
}
