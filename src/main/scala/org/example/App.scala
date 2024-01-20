package org.example

import org.apache.spark.sql.SparkSession
object App extends Logging {


  def main(args: Array[String]): Unit = {

    logger.info("Inicializando la sesion de Spark")

    implicit val spark: SparkSession = SparkSessionBuilder.initializeSparkSession(Exampleconst.name)

    logger.info("Leyendo la tabla de la base de datos")

    val df = DatabaseReader.readDatabaseTable

    logger.info("Mostrando los primeros registros del DataFrame")

    df.show()

    logger.info("Escribiendo el DataFrame a CSV en la ruta $path")

    CSVWriter.writeDataFrameToCSV(df)

    logger.info("Deteniendo la sesion de Spark")

    spark.stop()

  }
}
