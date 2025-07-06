package lecture

object CaseObject extends App {
  case object Logger {
    def log(message: String): Unit = {
      println(s"Log: $message")
    }
  }

  // Using the case object
  Logger.log("This is a log message")
}
