package org.example

import org.apache.spark.sql.SparkSession
import org.example.Logger.Logging
import org.example.SessionBuilder.SparkSessionBuilder
import org.example.constants.Exampleconst
import org.example.Layers.{BronzeLayer, SilverLayer, GoldLayer}

/**
 * The main application object for processing data using Spark.
 *
 * This object is the entry point for the Spark application. It initializes the Spark session,
 * processes data through different layers (Bronze, Silver, and Gold), and then terminates the Spark session.
 */
object App extends Logging {

  /**
   * The main method of the application.
   *
   * @param args Command line arguments passed to the application. Currently not used.
   */
  def main(args: Array[String]): Unit = {

    // Logging the start of the application
    logger.info("Starting the Spark application")

    // Initialize SparkSession with settings from Exampleconst
    logger.info("Initializing Spark session with settings from Exampleconst")
    implicit val spark: SparkSession = SparkSessionBuilder.initializeSparkSession(Exampleconst.name)

    // Process data through the Bronze layer
    logger.info("Processing data through the Bronze layer")
    BronzeLayer.processBronzeLayer

    // Process data through the Silver layer
    logger.info("Processing data through the Silver layer")
    SilverLayer.processSilverLayer

    // Process data through the Gold layer
    logger.info("Processing data through the Gold layer")
    GoldLayer.processGoldLayer

    // Logging the termination of the Spark session
    logger.info("Stopping the Spark session and releasing resources")
    spark.stop()

    // Final log indicating the end of the application
    logger.info("Spark application terminated successfully")
  }
}
