package lecture
import scala.util.{Try, Success, Failure}

object Exception extends App {
  // throw keyword
  // throw new IllegalArgumentException("Invaild argument")

  def divide(x: Int, y: Int): Int = {
    if(y == 0) throw new ArithmeticException("Cannot divide by zero")
    else x / y
  }

  // try & catch & finally keyword
  try {
    divide(10, 0)
  } catch {
    case e: ArithmeticException => println("Arithmetic problem: " + e.getMessage)
    case e: Exception => println("Error: " + e.getMessage)
  } finally {
    println("This will always be printed.")
  }

  // using Try class
  val result = Try(divide(10, 0))
  result match {
    case Success(value) => println(s"Result: $value")
    case Failure(exception) => println(s"Failed with exception: ${exception.getMessage}")
  }

  // custom Exception
  class MyCustomException(message: String) extends Exception(message)
  def myFunction(condition: Boolean): Unit = {
    if (condition) throw new MyCustomException("My custom exception...")
  }

  try {
    myFunction(true)
  } catch {
    case e: Exception => println("Error: " + e.getMessage)
  }
}
