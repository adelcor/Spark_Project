package MedallionTest

import org.apache.spark.sql.{Dataset, SparkSession}
import org.example.CaseClass.PedidoEnriquecido

/**
 * Helper object for data creation tasks.
 *
 * This object provides utility methods to work with datasets, particularly
 * for creating datasets of enriched orders (`PedidoEnriquecido`).
 */
object DataCreationHelper {

  /**
   * Creates a Dataset of PedidoEnriquecido from a sequence of PedidoEnriquecido.
   *
   * This method converts a sequence of PedidoEnriquecido into a Spark Dataset
   * using the implicit SparkSession. Datasets offer benefits like efficient off-heap
   * storage and optimized execution plans.
   *
   * @param pedidos The sequence of PedidoEnriquecido to convert into a Dataset.
   * @param spark Implicit SparkSession that provides the necessary context for Dataset operations.
   * @return A Dataset of PedidoEnriquecido.
   */
  def crearDatasetDePedidosEnriquecidos(pedidos: Seq[PedidoEnriquecido])(implicit spark: SparkSession): Dataset[PedidoEnriquecido] = {
    // Importing Spark implicits for enabling encoder conversions.
    import spark.implicits._

    // Converting the sequence to a Dataset and returning.
    pedidos.toDS()
  }
}
