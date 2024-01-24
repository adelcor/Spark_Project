package MedallionTest

import org.apache.spark.sql.SparkSession

/**
 * Object that provides utility methods for creating Spark sessions.
 */
object SparkSessionTest {

  /**
   * Creates and returns a SparkSession.
   *
   * A SparkSession is the entry point to programming Spark with the Dataset and DataFrame API.
   * This method creates a SparkSession with a specified application name and a local master.
   *
   * @param appName The name of the Spark application.
   * @return A SparkSession instance.
   */
  def createSparkSession(appName: String): SparkSession = {
    // Builder pattern is used to construct the SparkSession
    SparkSession.builder()
      .appName(appName) // Sets the name of the application
      .master("local[*]") // Sets the master URL to connect to, using all local cores
      .getOrCreate() // Gets an existing SparkSession or, if there is none, creates a new one
  }
}
