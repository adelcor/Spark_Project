package org.example.Layers

import org.apache.spark.sql.{Dataset, SparkSession}
import org.example.CaseClass.{Cliente, ClientePedido, Pedido, PedidoEnriquecido, Producto, ProductoFiltrado, ProductoRenamed}
import org.example.DataSetUtilities.DataSetLoader._
import org.example.Logger.Logging
import org.example.constants.Exampleconst
import org.example.Connect.ConnectionPropertiesSetter.getConnectionProperties
import org.example.Layers.CustomImplicits.{ClientePedidoEncoder, PedidoEnriquecidoEncoder, ProductoFiltradoEncoder, ProductoRenamedEncoder}
import org.example.Writer.ParquetWriter.{writeToParquet, writeToTable}

/**
 * Object representing the Silver Layer in a Data Processing Pipeline.
 * Responsible for further refining and enriching data sets.
 */
object SilverLayer extends Logging {

  logger.info("Silver Layer initialization")

  /**
   * Creates a dataset by joining Pedidos and Clientes datasets.
   *
   * @param dsPedidos Dataset of Pedidos
   * @param dsClientes Dataset of Clientes
   * @return Dataset of ClientePedido
   */
  private def createClientePedidoDataset(dsPedidos: Dataset[Pedido], dsClientes: Dataset[Cliente]): Dataset[ClientePedido] = {
    logger.debug("Creating ClientePedido dataset")
    dsPedidos
      .join(dsClientes, Seq("id_cliente"))
      .as[ClientePedido]
  }

  /**
   * Renames a column in the Producto dataset.
   *
   * @param dsProductos Dataset of Producto
   * @return Dataset of ProductoRenamed
   */
  private def renameProductoColumn(dsProductos: Dataset[Producto]): Dataset[ProductoRenamed] = {
    logger.debug("Renaming Producto column")
    dsProductos
      .withColumnRenamed("nombre", "nombre_producto")
      .as[ProductoRenamed]
  }

  /**
   * Filters columns in the ProductoRenamed dataset.
   *
   * @param dsProductosRenamed Dataset of ProductoRenamed
   * @return Dataset of ProductoFiltrado
   */
  private def filterProductoColumns(dsProductosRenamed: Dataset[ProductoRenamed]): Dataset[ProductoFiltrado] = {
    logger.debug("Filtering Producto columns")
    dsProductosRenamed
      .select("id_producto", "id_proveedor", "nombre_producto", "categoria", "subcategoria", "marca")
      .as[ProductoFiltrado]
  }

  /**
   * Enriches Pedidos with Producto data.
   *
   * @param dsPedidosClientes Dataset of ClientePedido
   * @param dsProductoFiltrado Dataset of ProductoFiltrado
   * @return Dataset of PedidoEnriquecido
   */
  private def enrichPedidos(dsPedidosClientes: Dataset[ClientePedido], dsProductoFiltrado: Dataset[ProductoFiltrado])
  : Dataset[PedidoEnriquecido] = {
    logger.debug("Enriching Pedidos")
    dsPedidosClientes
      .join(dsProductoFiltrado, Seq("id_producto"))
      .as[PedidoEnriquecido]
  }

  /**
   * Main process function for the Silver Layer.
   * Orchestrates the loading, processing, and writing of datasets.
   *
   * @param spark Implicit SparkSession
   */
  def processSilverLayer(implicit spark: SparkSession): Unit = {
    logger.info("Processing Silver Layer")

    val dsClientes: Dataset[Cliente] = LoadCSVDataSet(Exampleconst.pathCliente)
    val dsPedidos: Dataset[Pedido] = LoadCSVDataSet(Exampleconst.pathPedido)
    val dsProductos: Dataset[Producto] = LoadCSVDataSet(Exampleconst.pathProducto)

    val dsPedidosClientes: Dataset[ClientePedido] = createClientePedidoDataset(dsPedidos, dsClientes)
    val dsProductosRenamed: Dataset[ProductoRenamed] = renameProductoColumn(dsProductos)
    val dsProductoFiltrado: Dataset[ProductoFiltrado] = filterProductoColumns(dsProductosRenamed)
    val dsSilver: Dataset[PedidoEnriquecido] = enrichPedidos(dsPedidosClientes, dsProductoFiltrado)

    logger.debug("Showing enriched dataset")
    dsSilver.show()

    logger.debug("Writing to Parquet")
    writeToParquet(Exampleconst.pathSilver, dsSilver)

    logger.debug("Writing to table")
    writeToTable(Exampleconst.url, Exampleconst.tableSilver, dsSilver)

    logger.info("Silver Layer processing complete")
  }
}
