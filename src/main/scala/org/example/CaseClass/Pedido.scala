package org.example.CaseClass

import java.sql.Date

/**
 * Represents a Pedido (order) in the system.
 *
 * @param idPedido   The unique identifier for the Pedido.
 * @param idCliente  The identifier of the client who placed the order.
 * @param idProducto The identifier of the product in the order.
 * @param cantidad   The quantity of the product ordered.
 * @param fecha      The date when the order was placed.
 */
case class Pedido(
                   id_pedido: Int,
                   id_cliente: Int,
                   id_producto: Int,
                   cantidad: Int,
                   fecha: Date
                 )
