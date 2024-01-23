package org.example.SessionBuilder

import org.apache.spark.sql.SparkSession
/**
 * Object responsible for building SparkSession.
 *
 * SparkSession is the entry point to programming Spark with the Dataset and DataFrame API.
 */
object SparkSessionBuilder {

  /**
   * Initializes and returns a SparkSession.
   *
   * This method creates a SparkSession which is used to initialize the various functionalities of Spark.
   *
   * @param appName The name of the Spark application. This name will be shown in the Spark web UI.
   * @return A SparkSession instance for the application.
   */
  def initializeSparkSession(appName: String): SparkSession = {
    // Builder pattern to construct a SparkSession.
    SparkSession.builder()
      .appName(appName) // Sets the name of the application.
      .master("local[*]") // Sets the Spark master URL. "local[*]" runs Spark locally with as many worker threads as logical cores on your machine.
      .getOrCreate() // Gets an existing SparkSession or, if there is none, creates a new one.
  }
}