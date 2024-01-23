package org.example.Layers
import org.apache.spark.sql.{Dataset, SparkSession}
import org.example.CaseClass.{Cliente, ClientePedido, Pedido, PedidoEnriquecido, Producto, ProductoFiltrado, ProductoRenamed}
import org.example.DataSetUtilities.DataSetLoader._
import org.example.Logger.Logging
import org.example.constants.Exampleconst
import org.example.Connect.ConnectionPropertiesSetter
import org.example.Layers.CustomImplicits.{ClientePedidoEncoder, PedidoEnriquecidoEncoder, ProductoFiltradoEncoder, ProductoRenamedEncoder}



object SilverLayer extends Logging {
  def processSilverLayer(implicit spark: SparkSession): Unit = {
    val dsClientes: Dataset[Cliente] = LoadDataSet(Exampleconst.pathCliente)
    val dsPedidos: Dataset[Pedido] = LoadDataSet(Exampleconst.pathPedido)
    val dsProductos: Dataset[Producto] = LoadDataSet(Exampleconst.pathProducto)


    val dsPedidosClientes: Dataset[ClientePedido] = dsPedidos
      .join(dsClientes, Seq("id_cliente"))
      .as[ClientePedido]

    val dsProductosRenamed: Dataset[ProductoRenamed] = dsProductos
      .withColumnRenamed("nombre", "nombre_producto")
      .as[ProductoRenamed]

    val dsProductoFiltrado: Dataset[ProductoFiltrado] = dsProductosRenamed
      .select("id_producto", "id_proveedor", "nombre_producto", "categoria", "subcategoria", "marca")
      .as[ProductoFiltrado]

    val dsSilver: Dataset[PedidoEnriquecido] = dsPedidosClientes
      .join(dsProductoFiltrado, Seq("id_producto"))
      .as[PedidoEnriquecido]


    dsSilver.show()
    dsSilver.write.parquet(Exampleconst.pathSilver)
    val properties2 = ConnectionPropertiesSetter.getConnectionProperties
    dsSilver.write.jdbc(Exampleconst.url, "Silver", properties2)


  }
}

