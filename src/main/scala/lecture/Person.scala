package lecture

// Define the Person class
class Person(val name: String, age: Int) {
  // Class parameters name and age are used to initialize class members.

  // Overloading
  def greet(): String = s"Hello, my name is $name and I am $age years old."
  def greet(name: String) = s"Hello, my name is ${this.name} and I am $age years old. Nice to meet you $name."

  // Constructor
  def this(name: String) = this(name, 40)
  def this() = this("Joon")
}
