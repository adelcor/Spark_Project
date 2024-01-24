package org.example.CaseClass

import java.sql.Date

/**
 * Represents a client's order in the system.
 *
 * @param id_cliente  Unique identifier for the client.
 * @param nombre      First name of the client.
 * @param apellido1   First surname of the client.
 * @param apellido2   Second surname of the client, if applicable.
 * @param email       Email address of the client.
 * @param telefono    Contact phone number of the client.
 * @param id_pedido   Unique identifier for the order.
 * @param id_producto Identifier for the product in the order.
 * @param cantidad    Quantity of the product ordered.
 * @param fecha       Date when the order was placed.
 */
case class ClientePedido(
                          id_cliente: Int,
                          nombre: String,
                          apellido1: String,
                          apellido2: String,
                          email: String,
                          telefono: String,
                          id_pedido: Int,
                          id_producto: Int,
                          cantidad: Int,
                          fecha: Date
                        )
