package org.example.CaseClass

/**
 * A case class representing a client or customer.
 *
 * @param idCliente The unique identifier for the client.
 * @param nombre The first name of the client.
 * @param apellido1 The first last name of the client.
 * @param apellido2 The second last name of the client.
 * @param email The email address of the client.
 * @param telefono The phone number of the client.
 */
case class Cliente(
                    id_cliente: Int,
                    nombre: String,
                    apellido1: String,
                    apellido2: String,
                    email: String,
                    telefono: String
                  )
