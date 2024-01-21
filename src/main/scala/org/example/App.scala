package org.example

import org.apache.spark.sql.SparkSession
import org.example.Logger.Logging
import org.example.SessionBuilder.SparkSessionBuilder
import org.example.constants.Exampleconst
import org.example.Layers.BronzeLayer
object App extends Logging {


  def main(args: Array[String]): Unit = {

    logger.info("Inicializando la sesion de Spark")

    implicit val spark: SparkSession = SparkSessionBuilder.initializeSparkSession(Exampleconst.name)

    BronzeLayer.processBronzeLayer

    logger.info("Deteniendo la sesion de Spark")

    spark.stop()

  }
}
