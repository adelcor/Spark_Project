import org.apache.spark.sql.SparkSession
import org.example._

object App {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSessionBuilder.initializeSparkSession(Exampleconst.name)

    val jdbcUrl = Exampleconst.url
    val path = Exampleconst.path


    // Establecer las propiedades de conexión usando la función importada
    val connectionProperties = ConnectionPropertiesSetter.getConnectionProperties

    val tableName = Exampleconst.tableName

    // Llamar a la función para conectarse a la base de datos y leer la tabla usando la función importada
    val df = DatabaseReader.readDatabaseTable(spark, jdbcUrl, tableName, connectionProperties)

    df.show()

    CSVWriter.writeDataFrameToCSV(df,path)
    spark.stop()
  }
}
