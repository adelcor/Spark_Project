package org.example.Logger

import org.apache.logging.log4j.{LogManager, Logger}

/**
 * Trait that provides logging functionality.
 *
 * This trait can be mixed into any class that requires logging capabilities.
 * It provides a `logger` val which is an instance of `Logger` from the Log4j library.
 * The logger is initialized with the class name of the class into which this trait is mixed.
 */
trait Logging {
  // Logger instance specific to the class that mixes in this trait.
  // The logger is obtained using the `LogManager` from the Log4j library.
  // `getClass` ensures that the logger is tagged with the correct class name.
  val logger: Logger = LogManager.getLogger(getClass)
}
