import org.apache.spark.sql.SparkSession
import org.example._
import org.apache.logging.log4j.Logger
object App extends Logging {


  def main(args: Array[String]): Unit = {

    logger.info("Inicializando la sesion de Spark")

    val spark: SparkSession = SparkSessionBuilder.initializeSparkSession(Exampleconst.name)


    val jdbcUrl = Exampleconst.url
    val path = Exampleconst.path

    logger.info("Estableciendo las propiedades de conexion")
    // Establecer las propiedades de conexión usando la función importada
    val connectionProperties = ConnectionPropertiesSetter.getConnectionProperties

    val tableName = Exampleconst.tableName

    logger.info(s"Leyendo la tabla de la base de datos $tableName")
    // Llamar a la función para conectarse a la base de datos y leer la tabla usando la función importada
    val df = DatabaseReader.readDatabaseTable(spark, jdbcUrl, tableName, connectionProperties)
    logger.info("Mostrando los primeros registros del DataFrame")
    df.show()
    logger.info("Escribiendo el DataFrame a CSV en la ruta $path")
    CSVWriter.writeDataFrameToCSV(df,path)
    logger.info("Deteniendo la sesion de Spark")
    spark.stop()

  }
}
