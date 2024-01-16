package org.example

import java.util.Properties
import scala.io.Source

object ConnectionPropertiesSetter {
  private val properties: Properties = loadPropertiesFromFile("/application.properties")

  private def loadPropertiesFromFile(filePath: String): Properties = {
    val props = new Properties()
    val source = Source.fromURL(getClass.getResource(filePath))
    props.load(source.bufferedReader())
    source.close()
    props
  }

  def getConnectionProperties: Properties = {
    val connectionProperties = new Properties()
    val user = properties.getProperty("db.user")
    val password = properties.getProperty("db.password")
    // Asegúrate de añadir validación o manejo de errores aquí en caso de que las propiedades no existan.
    connectionProperties.setProperty("user", user)
    connectionProperties.setProperty("password", password)
    connectionProperties
  }
}
