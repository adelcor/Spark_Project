package samples
import org.apache.spark.sql.{Dataset, SparkSession}
import org.example.CaseClass.{PedidoEnriquecido, PedidoHashed}
import org.scalatest.{Assertions, FunSuite, Matchers}
import org.scalatest.matchers._
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

import scala.collection._
import org.junit.Test
import org.example._



class MiPrueba extends FunSuite with Matchers{
  def crearDatasetDePedidosEnriquecidos(pedidos: List[PedidoEnriquecido], spark: SparkSession): Dataset[PedidoEnriquecido] = {
    import spark.implicits._

    // Convierte la lista de PedidoEnriquecido en un Dataset
    val datasetPedidos = pedidos.toDS()
    datasetPedidos
  }

  val spark: SparkSession = SparkSession.builder()
    .appName("EjemploDatasetPedidoEnriquecido")
    .master("local[*]")
    .getOrCreate()
  val pedidosEnriquecidos: List[PedidoEnriquecido] = List(
    PedidoEnriquecido(1, 1, 101, 201, 5, new java.sql.Date(System.currentTimeMillis()), "Nombre1", "Apellido1", "Apellido2", "email1@example.com", "1234567890", "Producto1", "Categoria1", "Subcategoria1", "Marca1"),
    PedidoEnriquecido(2, 2, 102, 202, 3, new java.sql.Date(System.currentTimeMillis()), "Nombre2", "Apellido3", "Apellido4", "email2@example.com", "9876543210", "Producto2", "Categoria2", "Subcategoria2", "Marca2"),
    // Agrega más objetos PedidoEnriquecido según tus datos
  )
 val dsTest: Dataset[PedidoEnriquecido] = crearDatasetDePedidosEnriquecidos(pedidosEnriquecidos, spark)

  val dsHashed: Dataset[PedidoHashed]

  dsTest.show()

}
