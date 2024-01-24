package MedallionTest

import org.apache.spark.sql.SparkSession
import org.example.Layers.GoldLayer
import org.scalatest.{FunSuite, Matchers}

/**
 * A test suite for validating the functionality of the GoldLayer in processing datasets.
 * This suite checks the integrity and transformations applied to datasets of enriched orders.
 *
 * @constructor creates a test suite for the GoldLayer operations.
 */
class MiPrueba extends FunSuite with Matchers {
  // Create a SparkSession for testing purposes.
  implicit val spark: SparkSession = SparkSessionTest.createSparkSession("EjemploDatasetPedidoEnriquecido")

  /**
   * Test to verify that the transformed dataset has the expected number of columns.
   * This test applies a specific transformation to a sample dataset and checks
   * if the resulting dataset has 15 columns, as expected after the transformation.
   */
  test("dsHashed debe tener 15 columnas") {
    // Create a dataset of enriched orders for testing.
    val dsTest = DataCreationHelper.crearDatasetDePedidosEnriquecidos(TestData.pedidosEnriquecidos)

    // Apply the hashing transformation to the dataset.
    val dsHashed = GoldLayer.hashEmailAndTelefono(dsTest)

    // Assert that the transformed dataset has exactly 15 columns.
    assert(dsHashed.columns.length === 15)
  }
}

