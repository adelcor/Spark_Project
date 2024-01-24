package org.example.Layers

import org.apache.spark.sql.functions.{col, countDistinct, datediff, lit, sha2}
import org.apache.spark.sql.{Dataset, SparkSession, functions}
import org.example.CaseClass.{ClienteRFM, PedidoEnriquecido, PedidoHashed}
import org.example.Connect.ConnectionPropertiesSetter.getConnectionProperties
import org.example.DataSetUtilities.DataSetLoader.LoadParquetDataSet
import org.example.Logger.Logging
import org.example.constants.Exampleconst
import org.example.Layers.CustomImplicits.PedidoHashedEncoder
import org.example.Writer.ParquetWriter.{writeToParquet, writeToTable}

import java.sql.Date
import java.time.LocalDate

/**
 * Object responsible for processing the Gold Layer in a data pipeline.
 * This includes hashing sensitive information, calculating RFM metrics, and persisting the results.
 */
object GoldLayer extends Logging {

  /**
   * Hashes email and phone number fields in the dataset.
   *
   * @param dsEnriquecido The enriched dataset with email and phone fields.
   * @return A dataset with hashed email and phone fields.
   */
  def hashEmailAndTelefono(dsEnriquecido: Dataset[PedidoEnriquecido]) : Dataset[PedidoHashed] = {
    logger.info("Hashing email and phone number fields.")
    dsEnriquecido
      .withColumn("email_hashed", sha2(col("email"), 256))
      .withColumn("telefono_hashed", sha2(col("telefono").cast("string"), 256))
      .drop("email", "telefono")
      .as[PedidoHashed]
  }

  /**
   * Calculates RFM (Recency, Frequency, Monetary) metrics for each client.
   *
   * @param dsHashed The hashed dataset.
   * @param spark    Implicit SparkSession.
   * @return A dataset of clients with their RFM metrics.
   */
  private def calculateRFM(dsHashed: Dataset[PedidoHashed])(implicit spark: SparkSession): Dataset[ClienteRFM] = {
    logger.info("Calculating RFM metrics for clients.")
    import spark.implicits._

    // Calculating Recency
    val recencyDF = dsHashed
      .groupBy($"id_cliente")
      .agg(functions.max($"fecha").as("last_purchase_date"))
      .select($"id_cliente", datediff(lit(Date.valueOf(LocalDate.now())), $"last_purchase_date").as("recency"))

    // Calculating Frequency
    val frequencyDF = dsHashed
      .groupBy($"id_cliente")
      .agg(countDistinct($"id_pedido").as("frequency"))

    // Calculating Monetary value
    val monetaryDF = dsHashed
      .groupBy($"id_cliente")
      .agg(functions.sum($"cantidad").as("monetary"))

    // Joining all metrics into a single DataFrame
    val rfmDF = recencyDF
      .join(frequencyDF, "id_cliente")
      .join(monetaryDF, "id_cliente")
      .as[ClienteRFM]

    rfmDF
  }

  /**
   * Main process for handling the Gold Layer.
   *
   * @param spark Implicit SparkSession.
   */
  def processGoldLayer(implicit spark: SparkSession): Unit = {
    logger.info("Starting the Gold Layer processing.")

    // Loading and processing datasets
    val dsEnriquecido: Dataset[PedidoEnriquecido] = LoadParquetDataSet(Exampleconst.pathSilver)
    logger.info("Loaded enriched dataset.")
    val dsHashed: Dataset[PedidoHashed] = hashEmailAndTelefono(dsEnriquecido)
    logger.info("Completed hashing of email and phone number.")
    val dsRFM: Dataset[ClienteRFM] = calculateRFM(dsHashed)
    logger.info("RFM calculation completed.")

    // Showing results
    dsHashed.show()
    dsRFM.show()

    // Writing results to parquet files and database tables
    writeToParquet(Exampleconst.pathGold, dsRFM)
    logger.info("RFM dataset written to Parquet.")
    writeToParquet(Exampleconst.pathGoldHashed, dsHashed)
    logger.info("Hashed dataset written to Parquet.")
    writeToTable(Exampleconst.url, Exampleconst.tableGold, dsRFM)
    logger.info("RFM dataset written to database table.")
    writeToTable(Exampleconst.url, Exampleconst.tableGoldHashed, dsHashed)
    logger.info("Hashed dataset written to database table.")
  }
}
