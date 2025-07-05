package lecture

object Function extends App {
  def add(a: Int, b: Int): Int = {
    a + b
  }
  println(add(1, 2))

  // concise version
  def add2(a: Int, b: Int): Int = a + b
  print(add2(2, 3))

  // function types(assign anonymous function to val)
  val subtract = (a: Int, b: Int) => a - b
  val result = subtract(10, 3)
  println(result)

  // Key diff between = and =>
  // = : comes function body(method definitions),
  // =>(fat arrow) : comes function type(function literal)

  // higer order function
  def operateOnNumbers(a: Int, b: Int, operation: (Int, Int) => Int): Int = {
    operation(a, b)
  }
  val outputSum = operateOnNumbers(2, 3, add)
  println(outputSum)

  // anonymous function(function literals)
  val result1 = operateOnNumbers(3, 4, (x, y) => x * y)
  println(result1)

  // nested function
  def factorial(n: Int): Int = {
    def iter(x: Int, result: Int): Int = {
      if (x <= 0) result
      else iter(x - 1, x * result)
    }
    iter(n, 1)
  }
  println(factorial(4))

  // default parameters and named arguments, String interpolation ${XXX}
  def greet(name: String, greeting: String = "Hello"): String = s"${greeting}, $name!"
  println(greet(name = "Alice", greeting = "Hi"))
  println(greet(name = "Bob"))

  // varargs(variable number of arguments)
  def totalSum(numbers: Int*): Int = numbers.sum
  println(totalSum(1, 7, 5, 4))

  def concatenate(strings: String*): String = {
    strings.mkString
  }
  println(concatenate("Hello ", "Concat ", "World ", "!"))

  def findMax(numbers: Int*): Int = {
    numbers.max
  }
  println(findMax(1, 2, 3, 10))

  def printAll(strings: String*): Unit = {
    for(str <- strings) {
      print(str)
    }
  }
  printAll("Scala ", "is ", "fun")

  def greet2(greeting: String, names: String*): Unit = {
    names.foreach(name => println(s"$greeting $name"))
  }
  greet2("Hello", "Alice", "Bob", "Charlie")

  // partial function: PartialFunction[INPUT_VALUE, OUTPUT_TYPE]
  val handleStrings: PartialFunction[String, String] = {
    case "Scala" => "A great language"
    case "Java" => "A classic language"
  }
  println(handleStrings("Scala"))
  // println(handleStrings("Python")) // scala.MatchError: Python (of class java.lang.String)

  // check if partial function is defined
  if (handleStrings.isDefinedAt("Ruby")) {
    println(handleStrings("Ruby"))
  } else {
   println("No information about Ruby")
  }

  case class Person(name: String, age: Int)
  case class Product(name: String, price: Double)

  val handleEntities: PartialFunction[Any, String] = {
    case Person(name, _) => s"This is a person named $name."
    case Product(name, price) => s"This is a product named $name($$ $price)"
  }
  println(handleEntities(Person("Alice", 30)))
  println(handleEntities(Product("Book", 10.99)))
}

