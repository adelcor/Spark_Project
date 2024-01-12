package org.example
import java.util.Properties

object ConnectionPropertiesSetter {
  def setConnectionProperties(user: String, password: String): Properties = {
    val properties = new Properties()
    properties.setProperty("user", user)
    properties.setProperty("password", password)
    properties
  }
}
