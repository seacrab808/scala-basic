package lecture

object StaticClass extends App {
  // Define a class
  class Person(name: String, age: Int) {
    def greet(): String = s"Hello, my name is $name and I am $age years old."
  }

  // Define a compaion object
  object Person {
    // Factory method to create Person instances
    def apply(name: String, age: Int): Person = new Person(name, age)

    // Static utility method
    def isValidAge(age: Int): Boolean = age >= 0
  }

  val person = Person("Alice", 30)

  // Accessing the greet method and utility method
  println(person.greet()) // Output: Hello, my name is Alice and I am 30 years old.
  println(Person.isValidAge(25)) // Output: true
}
