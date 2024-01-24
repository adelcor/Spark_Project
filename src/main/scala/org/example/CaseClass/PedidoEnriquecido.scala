package org.example.CaseClass

/**
 * Represents an enriched order (PedidoEnriquecido) with additional information.
 *
 * @param id_pedido       The unique identifier for the order.
 * @param id_cliente      The unique identifier for the customer.
 * @param id_producto     The unique identifier for the product.
 * @param id_proveedor    The unique identifier for the supplier.
 * @param cantidad        The quantity of the product in the order.
 * @param fecha           The date of the order.
 * @param nombre          The first name of the customer.
 * @param apellido1       The first last name of the customer.
 * @param apellido2       The second last name of the customer.
 * @param email           The customer's email address.
 * @param telefono        The customer's phone number.
 * @param nombre_producto The name of the product.
 * @param categoria       The category of the product.
 * @param subcategoria    The subcategory of the product.
 * @param marca           The brand of the product.
 */
case class PedidoEnriquecido(
                              id_pedido: Int,
                              id_cliente: Int,
                              id_producto: Int,
                              id_proveedor: Int,
                              cantidad: Int,
                              fecha: java.sql.Date,
                              nombre: String,
                              apellido1: String,
                              apellido2: String,
                              email: String,
                              telefono: String,
                              nombre_producto: String,
                              categoria: String,
                              subcategoria: String,
                              marca: String
                            )


