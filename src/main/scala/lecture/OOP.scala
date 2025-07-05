package lecture

object OOP extends App {
  // Create instance of the Person class
  val person1 = new Person("Alice", 30)
  val person2 = new Person("Bob", 25)

  // Use the greet() method
  println(person1.greet())
  println(person2.greet())
  println(person1.greet(name="Tom"))

  val person3 = new Person()
  println(person3.greet())

  val car1 = new Car(model = "modelS", year = 2024)
  car1.introduce()
  val car2 = new Car(model = "model3")
  car2.introduce()
  val car3 = new Car(year = 2022)
  car3.introduce()
}
