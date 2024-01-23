package org.example.Layers
import org.apache.spark.sql.{Encoder, Encoders}

import org.apache.spark.sql.{Encoder, Encoders}
import org.example.CaseClass.{ClientePedido, Pedido, Cliente, Producto, PedidoEnriquecido,ProductoFiltrado, ProductoRenamed}

object CustomImplicits {
  // Define Encoder para otras case class personalizadas si es necesario
  implicit val ClientePedidoEncoder: Encoder[ClientePedido] = Encoders.product[ClientePedido]

  implicit val PedidoEncoder: Encoder[Pedido] = Encoders.product[Pedido]

  implicit val ClienteEncoder: Encoder[Cliente] = Encoders.product[Cliente]

  implicit val ProductoEncoder: Encoder[Producto] = Encoders.product[Producto]

  implicit val PedidoEnriquecidoEncoder: Encoder[PedidoEnriquecido] = Encoders.product[PedidoEnriquecido]

  implicit val ProductoFiltradoEncoder: Encoder[ProductoFiltrado] = Encoders.product[ProductoFiltrado]

  implicit val ProductoRenamedEncoder: Encoder[ProductoRenamed] = Encoders.product[ProductoRenamed]


}
