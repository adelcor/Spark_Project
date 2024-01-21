package org.example.Layers

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.example.Logger.Logging
import org.example.Reader.DatabaseReader
import org.example.SessionBuilder.SparkSessionBuilder
import org.example.Writer.CSVWriter
import org.example.constants.Exampleconst
import org.example.Layers

object BronzeLayer extends Logging{

  def processBronzeLayer(implicit spark: SparkSession): Unit = {
    logger.info("Leyendo la tabla de la base de datos")

    val dfCliente: DataFrame = DatabaseReader.readTable(Exampleconst.tableCliente)
    val dfPedido: DataFrame = DatabaseReader.readTable(Exampleconst.tablePedido)
    val dfProducto: DataFrame = DatabaseReader.readTable(Exampleconst.tableProducto)
    val dfProveedor: DataFrame = DatabaseReader.readTable(Exampleconst.tableProveedor)

    logger.info("Mostrando los primeros registros del DataFrame")

    dfCliente.show()
    dfPedido.show()
    dfProducto.show()
    dfProveedor.show()


    logger.info(s"Escribiendo el DataFrame a CSV en la ruta ${Exampleconst.pathCliente}")

    CSVWriter.writeToCSV(Exampleconst.pathCliente, dfCliente)
    CSVWriter.writeToCSV(Exampleconst.pathPedido, dfPedido)
    CSVWriter.writeToCSV(Exampleconst.pathProducto, dfProducto)
    CSVWriter.writeToCSV(Exampleconst.pathProveedor, dfProveedor)
  }
}

