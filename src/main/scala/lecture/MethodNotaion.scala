package lecture

object MethodNotaion extends App {
  class MyNumber(var value: Int) {
    // infix notation - parameter : 1
    def add(x: Int): Int = x + this.value
    def subtract(x: Int): Int = this.value - x

//    // prefix notation(unary notation)
//    def unary_- : MyNumber = new MyNumber(-value)
//    def unary_! : String = s"Sorry, not possible"
//
//    // postfix
//    def isZero: Boolean = this.value == 0
//
//    // apply function
//    def apply(): String = s"MyNumber is ${this.value}!"
  }

  // Create an instance of the class
  val myNumber = new MyNumber(10)

  // infix notation to call methods
  val result1 = myNumber add 5 // Equivalent to MyNumber.add(5)
  val result2 = myNumber subtract 8 // Equivalent to MyNumber.subtract(8)
  println(result1) // Output: 15
  println(result2) // Output: 2
}
