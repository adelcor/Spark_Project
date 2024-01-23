package org.example.CaseClass

import java.sql.Date

case class ClientePedido(
                          id_cliente: Int,
                          nombre: String,
                          apellido1: String,
                          apellido2: String,
                          email: String,
                          telefono: String,
                          id_pedido: Int,
                          id_producto: Int,
                          cantidad: Int,
                          fecha: Date
                        )
