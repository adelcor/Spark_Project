import org.apache.spark.sql.SparkSession
import org.example._

object App {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSessionBuilder.initializeSparkSession("PostgreSQL with Spark")

    val jdbcUrl = "jdbc:postgresql://localhost:5432/"
    val user = "postgres"
    val password = "admin"  // Reemplazar con la contraseña real
    val path = "C:/Metro/test.csv"


    // Establecer las propiedades de conexión usando la función importada
    val connectionProperties = ConnectionPropertiesSetter.setConnectionProperties(user, password)

    val tableName = "shop_pedido"

    // Llamar a la función para conectarse a la base de datos y leer la tabla usando la función importada
    val df = DatabaseReader.readDatabaseTable(spark, jdbcUrl, tableName, connectionProperties)

    df.show()

    CSVWriter.writeDataFrameToCSV(df,path)
    spark.stop()
  }
}
