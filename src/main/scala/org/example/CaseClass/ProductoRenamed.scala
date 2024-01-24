package org.example.CaseClass

/**
 * A case class representing a product.
 *
 * @param id_producto    The unique identifier of the product.
 * @param id_proveedor   The identifier of the product's supplier.
 * @param nombre_producto The name of the product.
 * @param categoria      The category of the product.
 * @param subcategoria   The subcategory of the product.
 * @param marca          The brand of the product.
 * @param peso           The weight of the product in kilograms.
 * @param altura         The height of the product in centimeters.
 * @param anchura        The width of the product in centimeters.
 * @param profundidad    The depth of the product in centimeters.
 * @param importe        The price or cost of the product.
 * @param moneda         The currency in which the price is specified.
 */
case class ProductoRenamed(
                            id_producto: Int,
                            id_proveedor: Int,
                            nombre_producto: String,
                            categoria: String,
                            subcategoria: String,
                            marca: String,
                            peso: Double,
                            altura: Double,
                            anchura: Double,
                            profundidad: Double,
                            importe: Double,
                            moneda: String
                          )
