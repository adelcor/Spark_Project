package org.example.CaseClass

import java.sql.Date

/**
 * Represents a hashed pedido (order) data class.
 *
 * @param id_pedido      The unique identifier for the pedido.
 * @param id_cliente     The unique identifier for the cliente (customer).
 * @param id_producto    The unique identifier for the producto (product).
 * @param id_proveedor   The unique identifier for the proveedor (supplier).
 * @param cantidad       The quantity of the producto in the pedido.
 * @param fecha          The date when the pedido was made.
 * @param nombre         The first name of the cliente.
 * @param apellido1      The first last name of the cliente.
 * @param apellido2      The second last name of the cliente.
 * @param email_hashed   The hashed email address of the cliente.
 * @param telefono_hashed The hashed telephone number of the cliente.
 * @param nombre_producto The name of the producto.
 * @param categoria      The category of the producto.
 * @param subcategoria   The subcategory of the producto.
 * @param marca          The brand of the producto.
 */
case class PedidoHashed(
                         id_pedido: Int,
                         id_cliente: Int,
                         id_producto: Int,
                         id_proveedor: Int,
                         cantidad: Int,
                         fecha: Date,
                         nombre: String,
                         apellido1: String,
                         apellido2: String,
                         email_hashed: String,
                         telefono_hashed: String,
                         nombre_producto: String,
                         categoria: String,
                         subcategoria: String,
                         marca: String
                       )
