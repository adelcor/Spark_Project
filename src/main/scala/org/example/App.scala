package org.example

import org.apache.spark.sql.SparkSession
import org.example.Logger.Logging
import org.example.SessionBuilder.SparkSessionBuilder
import org.example.constants.Exampleconst
import org.example.Layers.BronzeLayer

/**
 * The main application object.
 *
 * This object serves as the entry point for the Spark application. It sets up
 * the Spark session, processes data through the Bronze layer, and then stops the Spark session.
 */
object App extends Logging {

  /**
   * The main method of the application.
   *
   * @param args Command line arguments passed to the application. Currently not used in the application.
   */
  def main(args: Array[String]): Unit = {

    // Log the start of the Spark session initialization
    logger.info("Inicializando la sesion de Spark")

    // Initialize SparkSession with settings from Exampleconst
    implicit val spark: SparkSession = SparkSessionBuilder.initializeSparkSession(Exampleconst.name)

    // Process data through the Bronze layer
    BronzeLayer.processBronzeLayer

    // Log the stopping of the Spark session
    logger.info("Deteniendo la sesion de Spark")

    // Stop the Spark session to release resources
    spark.stop()
  }
}
