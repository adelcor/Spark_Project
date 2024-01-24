package org.example.constants

/**
 * Constants for the Example application.
 *
 * This object contains various constants used in the application,
 * such as database URLs, file paths, and table names. These constants
 * are used to maintain consistency and facilitate changes in the codebase.
 */
object Exampleconst {

    // URL for the PostgreSQL database connection.
    val url: String = "jdbc:postgresql://localhost:5432/"

    // File paths for various CSV files used in the application.
    val pathPedido: String = "C:/project_spark/Spark_Project/Bronze/shop_pedido.csv"
    val pathCliente: String = "C:/project_spark/Spark_Project/Bronze/shop_cliente.csv"
    val pathProducto: String = "C:/project_spark/Spark_Project/Bronze/shop_producto.csv"
    val pathProveedor: String = "C:/project_spark/Spark_Project/Bronze/shop_proveedor.csv"

    // Names of the database tables.
    val tablePedido = "shop_pedido"
    val tableCliente = "shop_cliente"
    val tableProducto = "shop_producto"
    val tableProveedor = "shop_proveedor"
    val tableSilver = "Silver"

    // General application name.
    val name = "PostgreSQL with Spark"

    // Path to the application properties file.
    val Propertiespath = "/application.properties"

    val pathSilver: String = "C:/project_spark/Spark_Project/Silver/Silver.parquet"
}
