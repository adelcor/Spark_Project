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

    // Paths for Parquet files in Silver and Gold directories.
    val pathSilver: String = "C:/project_spark/Spark_Project/Silver/Silver.parquet"
    val pathGoldHashed: String = "C:/project_spark/Spark_Project/Gold/Gold_Hashed.parquet"
    val pathGold: String =  "C:/project_spark/Spark_Project/Gold/Gold.parquet"

    // Names of the database tables.
    val tablePedido = "shop_pedido"
    val tableCliente = "shop_cliente"
    val tableProducto = "shop_producto"
    val tableProveedor = "shop_proveedor"
    val tableSilver = "Silver"
    val tableGoldHashed = "GoldHashed"
    val tableGold = "Gold"

    // General application name.
    val name = "PostgreSQL with Spark"

    // Path to the application properties file.
    val Propertiespath = "/application.properties"

    /**
     * Retrieves the URL for the PostgreSQL database connection.
     *
     * @return A string representing the PostgreSQL database URL.
     */
    def getDatabaseUrl: String = url

    /**
     * Retrieves the file path for a specific CSV file used in the application.
     *
     * @param fileType The type of CSV file (e.g., "Pedido", "Cliente", "Producto", "Proveedor").
     * @return A string representing the file path for the specified CSV file.
     */
    def getCsvFilePath(fileType: String): String = {
        fileType.toLowerCase match {
            case "pedido" => pathPedido
            case "cliente" => pathCliente
            case "producto" => pathProducto
            case "proveedor" => pathProveedor
            case _ => ""
        }
    }

    /**
     * Retrieves the path for a Parquet file in the Silver or Gold directory.
     *
     * @param fileType The type of Parquet file (e.g., "Silver", "GoldHashed", "Gold").
     * @return A string representing the file path for the specified Parquet file.
     */
    def getParquetFilePath(fileType: String): String = {
        fileType.toLowerCase match {
            case "silver" => pathSilver
            case "goldhashed" => pathGoldHashed
            case "gold" => pathGold
            case _ => ""
        }
    }

}
