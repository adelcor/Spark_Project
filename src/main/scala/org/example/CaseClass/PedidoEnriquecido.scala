package org.example.CaseClass

case class PedidoEnriquecido(
                              id_pedido: Int,
                              id_cliente: Int,
                              id_producto: Int,
                              id_proveedor: Int,
                              cantidad: Int,
                              fecha: java.sql.Date,
                              nombre: String,
                              apellido1: String,
                              apellido2: String,
                              email: String,
                              telefono: String,
                              nombre_producto: String,
                              categoria: String,
                              subcategoria: String,
                              marca: String
                            )
