package org.example.Layers

import org.apache.spark.sql.{Encoder, Encoders}
import org.example.CaseClass.{Cliente, ClientePedido, Pedido, PedidoEnriquecido, PedidoHashed, Producto, ProductoFiltrado, ProductoRenamed}

/**
 * Provides custom implicit Encoders for case classes used in Spark SQL operations.
 *
 * Encoders are used by Spark to convert between JVM objects and Spark SQL's internal binary format.
 * This object provides encoders for various custom case classes that can be used in DataFrame and Dataset operations.
 */
object CustomImplicits {

  // Encoder for ClientePedido case class
  /**
   * Implicit Encoder for ClientePedido case class.
   *
   * @return Encoder for ClientePedido
   */
  implicit val ClientePedidoEncoder: Encoder[ClientePedido] = Encoders.product[ClientePedido]

  // Encoder for Pedido case class
  /**
   * Implicit Encoder for Pedido case class.
   *
   * @return Encoder for Pedido
   */
  implicit val PedidoEncoder: Encoder[Pedido] = Encoders.product[Pedido]

  // Encoder for Cliente case class
  /**
   * Implicit Encoder for Cliente case class.
   *
   * @return Encoder for Cliente
   */
  implicit val ClienteEncoder: Encoder[Cliente] = Encoders.product[Cliente]

  // Encoder for Producto case class
  /**
   * Implicit Encoder for Producto case class.
   *
   * @return Encoder for Producto
   */
  implicit val ProductoEncoder: Encoder[Producto] = Encoders.product[Producto]

  // Encoder for PedidoEnriquecido case class
  /**
   * Implicit Encoder for PedidoEnriquecido case class.
   *
   * @return Encoder for PedidoEnriquecido
   */
  implicit val PedidoEnriquecidoEncoder: Encoder[PedidoEnriquecido] = Encoders.product[PedidoEnriquecido]

  // Encoder for ProductoFiltrado case class
  /**
   * Implicit Encoder for ProductoFiltrado case class.
   *
   * @return Encoder for ProductoFiltrado
   */
  implicit val ProductoFiltradoEncoder: Encoder[ProductoFiltrado] = Encoders.product[ProductoFiltrado]

  // Encoder for ProductoRenamed case class
  /**
   * Implicit Encoder for ProductoRenamed case class.
   *
   * @return Encoder for ProductoRenamed
   */
  implicit val ProductoRenamedEncoder: Encoder[ProductoRenamed] = Encoders.product[ProductoRenamed]

  implicit val PedidoHashedEncoder: Encoder[PedidoHashed] = Encoders.product[PedidoHashed]
}

