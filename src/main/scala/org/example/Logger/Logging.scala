package org.example.Logger

import org.apache.logging.log4j.{LogManager, Logger}

/**
 * Trait that provides logging functionality.
 *
 * This trait can be mixed into any class to provide logging capabilities. It offers a `logger` val,
 * which is an instance of `Logger` from the Log4j library, initialized with the class name.
 *
 * Example Usage:
 * class MyClass extends Logging {
 *   logger.info("Logging info from MyClass")
 * }
 */
trait Logging {
  // Logger instance specific to the class that mixes in this trait.
  // The logger is obtained using the `LogManager` from the Log4j library.
  // `getClass` ensures that the logger is tagged with the correct class name.
  val logger: Logger = LogManager.getLogger(getClass)


}
