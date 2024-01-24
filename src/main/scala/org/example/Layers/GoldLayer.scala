package org.example.Layers
import org.apache.spark.sql.functions.{col, sha2}
import org.apache.spark.sql.{Dataset, SparkSession}
import org.example.CaseClass.PedidoEnriquecido
import org.example.DataSetUtilities.DataSetLoader.LoadParquetDataSet
import org.example.Logger.Logging
import org.example.constants.Exampleconst
import org.example.Layers.CustomImplicits.PedidoEnriquecidoEncoder
object GoldLayer extends Logging {

  def processGoldLayer(implicit spark: SparkSession): Unit ={

    val dsEnriquecido: Dataset[PedidoEnriquecido] = LoadParquetDataSet(Exampleconst.pathSilver)

    val dsHashed: Dataset[PedidoEnriquecido] = dsEnriquecido
      .withColumn("email_hashed", sha2(col("email"), 256))
      .withColumn("telefono_hashed", sha2(col("telefono").cast("string"), 256))
      .as[PedidoEnriquecido]


    dsHashed.show()
  }


}
