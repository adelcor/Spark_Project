package org.example.CaseClass

/**
 * Represents a client's RFM (Recency, Frequency, Monetary) data.
 *
 * @param id_cliente The unique identifier for the client.
 * @param recency The recency score indicating how recently the client made a purchase or engaged with the business.
 * @param frequency The frequency score representing how often the client makes purchases or engages with the business.
 * @param monetary The monetary score indicating the total monetary value of the client's transactions.
 */
case class ClienteRFM(
                       id_cliente: Int,
                       recency: Int,
                       frequency: Long,
                       monetary: Double
                     )
