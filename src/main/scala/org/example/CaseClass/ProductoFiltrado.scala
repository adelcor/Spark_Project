package org.example.CaseClass

/**
 * A case class representing a filtered product.
 *
 * @param id_producto     The unique identifier for the product.
 * @param id_proveedor    The unique identifier for the supplier or provider of the product.
 * @param nombre_producto The name of the product.
 * @param categoria       The category to which the product belongs.
 * @param subcategoria    The subcategory to which the product belongs.
 * @param marca           The brand or manufacturer of the product.
 */
case class ProductoFiltrado(
                             id_producto: Int,
                             id_proveedor: Int,
                             nombre_producto: String,
                             categoria: String,
                             subcategoria: String,
                             marca: String
                           )
