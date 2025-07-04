package lecture

object Expression extends App {
  // Basic Arithmetic Expression
  var sum = 10 + 5
  sum += 10
  println(sum)

  // Conditional Expression(If-Else)
  val a1 = 4
  val a2 = 5
  val max = if (a1 > a2) a1 else a2
  println(max)

  // Negation
  println(!(1 == 1))

  // Block Expression
  val blockValue = {
    val a = 10
    val b = 5
    a + b
  }
  println(blockValue)

  // Fucntion as an Expression
  val multiply = (x: Int, y: Int) => x * y
  println(multiply(3, 4))

  // Case Classes and Pattern Matching
  case class Point(x:Int, y:Int)
  val point = Point(1, 2)
  val description = point match {
    case Point(0, 0) => "Origin"
    case Point(x, 0) => s"X axis at $x"
    case Point(0, y) => s"Y axis at $y"
    case _ => "Somewhere on the plane"
  }
  println(description)

  // Collection Operations
  val numbers = List(1, 2, 3, 4, 5)
  val doubled = numbers.map(_ * 2) // List(2, 4, 6, 8, 10)
  println(doubled)

  println(println(123)) // return ()
}
