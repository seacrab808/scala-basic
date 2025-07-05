package lecture

object VariableType extends App {
  // Immutable : val
  val constantValue: Int = 31
  println(constantValue)

  // Mutable : var
  var mutableValue = 10
  mutableValue = 20
  println(mutableValue)

  // Type Inference
  val number = 42
  println(number.isInstanceOf[Int])
  var name = "Scala"
  println(name.isInstanceOf[String])

  // Built-in Data Types
  val byteVal: Byte = 100
  println(byteVal)

  val shortVal: Short = 100
  println(shortVal)

  val intVal: Int = 1000
  println(intVal)

  val longVal: Long = 10000L
  println(longVal)

  val floatVal: Float = 10.5f
  println(floatVal)

  val doubleVal: Double = 10.5
  println(doubleVal)

  val charVal: Char = 'A'
  println(charVal)

  val booleanVal: Boolean = true
  println(booleanVal)

  val stringVal: String = "Hello, Scala"
  println(stringVal)
}
