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

object GoldLayer extends Logging {
  private def hashEmailAndTelefono(dsEnriquecido: Dataset[PedidoEnriquecido]) : Dataset[PedidoHashed] = {
    dsEnriquecido
      .withColumn("email_hashed", sha2(col("email"), 256))
      .withColumn("telefono_hashed", sha2(col("telefono").cast("string"), 256))
      .drop("email", "telefono")
      .as[PedidoHashed]
  }

  private def calculateRFM(dsHashed: Dataset[PedidoHashed])(implicit spark: SparkSession): Dataset[ClienteRFM] = {
    import spark.implicits._

    // Calcula recency
    val recencyDF = dsHashed
      .groupBy($"id_cliente")
      .agg(functions.max($"fecha").as("last_purchase_date"))
      .select($"id_cliente", datediff(lit(Date.valueOf(LocalDate.now())), $"last_purchase_date").as("recency"))

    // Calcula frequency
    val frequencyDF = dsHashed
      .groupBy($"id_cliente")
      .agg(countDistinct($"id_pedido").as("frequency"))

    // Calcula monetary
    val monetaryDF = dsHashed
      .groupBy($"id_cliente")
      .agg(functions.sum($"cantidad").as("monetary"))

    // Une las métricas RFM en un solo DataFrame y conviértelo a Dataset[ClienteRFM]
    val rfmDF = recencyDF
      .join(frequencyDF, "id_cliente")
      .join(monetaryDF, "id_cliente")
      .as[ClienteRFM]

    rfmDF
  }
  def processGoldLayer(implicit spark: SparkSession): Unit = {

    val dsEnriquecido: Dataset[PedidoEnriquecido] = LoadParquetDataSet(Exampleconst.pathSilver)
    val dsHashed: Dataset[PedidoHashed] = hashEmailAndTelefono(dsEnriquecido)
    val dsRFM: Dataset[ClienteRFM] = calculateRFM(dsHashed)

    dsHashed.show()

    dsRFM.show()
    writeToParquet(Exampleconst.pathGold, dsRFM)
    writeToParquet(Exampleconst.pathGoldHashed, dsHashed)
    writeToTable(Exampleconst.url, Exampleconst.tableGold, dsRFM)
    writeToTable(Exampleconst.url, Exampleconst.tableGoldHashed, dsHashed)


  }


}

