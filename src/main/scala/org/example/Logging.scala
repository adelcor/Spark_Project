import org.apache.logging.log4j.{LogManager, Logger}

trait Logging {
  val logger: Logger = LogManager.getLogger(getClass)
}
