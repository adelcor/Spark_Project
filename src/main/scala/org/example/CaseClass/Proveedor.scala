package org.example.CaseClass

/**
 * Represents a provider information.
 *
 * @param id_proveedor    The unique identifier for the provider.
 * @param compania        The name of the company.
 * @param contacto        The contact person's name.
 * @param direccion       The address of the company.
 * @param ciudad          The city where the company is located.
 * @param region          The region or state where the company is located.
 * @param codigoPostal    The postal code of the company's location.
 * @param pais            The country where the company is located.
 * @param telefono        The phone number of the company.
 * @param fax             The fax number of the company.
 * @param paginaPrincipal The main website URL of the company.
 */
case class Proveedor(
                      id_proveedor: Int,
                      compania: String,
                      contacto: String,
                      direccion: String,
                      ciudad: String,
                      region: String,
                      codigoPostal: String,
                      pais: String,
                      telefono: String,
                      fax: String,
                      paginaPrincipal: String
                    )
