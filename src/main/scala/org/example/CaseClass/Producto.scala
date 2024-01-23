package org.example.CaseClass

/**
 * A case class representing a product.
 *
 * @param idProducto    The unique identifier for the product.
 * @param idProveedor   The unique identifier for the supplier of the product.
 * @param nombre        The name of the product.
 * @param categoria     The category of the product.
 * @param subcategoria  The subcategory of the product.
 * @param marca         The brand or manufacturer of the product.
 * @param peso          The weight of the product in kilograms.
 * @param altura        The height of the product in centimeters.
 * @param anchura       The width of the product in centimeters.
 * @param profundidad   The depth of the product in centimeters.
 * @param importe       The price or cost of the product.
 * @param moneda        The currency used for the price of the product.
 */
case class Producto(
                     id_producto: Int,
                     id_proveedor: Int,
                     nombre: String,
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
