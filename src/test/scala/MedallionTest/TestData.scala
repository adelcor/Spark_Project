package MedallionTest

import org.example.CaseClass.PedidoEnriquecido

import java.sql.Date

/**
 * Object containing test data for `PedidoEnriquecido` instances.
 *
 * This object provides a list of `PedidoEnriquecido` objects that can be used for testing purposes.
 * Each `PedidoEnriquecido` represents an enriched order with various attributes like id, client id, etc.
 */
object TestData {

  // Current system time used for creating date objects for the test data.
  private val currentTime: Date = new java.sql.Date(System.currentTimeMillis())

  /**
   * A list of pre-defined `PedidoEnriquecido` objects.
   *
   * This list is intended for use in test scenarios where pre-populated data of `PedidoEnriquecido`
   * type is required. It contains various instances with different sets of data.
   */
  val pedidosEnriquecidos: List[PedidoEnriquecido] = List(
    PedidoEnriquecido(1, 1, 101, 201, 5, currentTime, "Nombre1", "Apellido1", "Apellido2", "email1@example.com", "1234567890", "Producto1", "Categoria1", "Subcategoria1", "Marca1"),
    PedidoEnriquecido(2, 2, 102, 202, 3, currentTime, "Nombre2", "Apellido3", "Apellido4", "email2@example.com", "9876543210", "Producto2", "Categoria2", "Subcategoria2", "Marca2"),
  )
}
