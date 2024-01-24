package org.example.CaseClass

case class PedidoHashed(
                              id_pedido: Int,
                              id_cliente: Int,
                              id_producto: Int,
                              id_proveedor: Int,
                              cantidad: Int,
                              fecha: java.sql.Date,
                              nombre: String,
                              apellido1: String,
                              apellido2: String,
                              email_hashed: String,
                              telefono_hashed: String,
                              nombre_producto: String,
                              categoria: String,
                              subcategoria: String,
                              marca: String,


                            )
