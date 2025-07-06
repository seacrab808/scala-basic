package lecture
import java.io.{ByteArrayInputStream, ByteArrayOutputStream, ObjectInputStream, ObjectOutputStream}
import scala.util.Try

object CaseClass extends App {
  case class Person(name: String, age: Int)

  // Creating instance of the case class
  val alice = Person("Alice", 30)
  val alice2 = Person("Alice", 30)
  // Equals and Hash code
  println(alice == alice2) // Output: true

  // no new keyword
  val bob = Person("Bob", 25)

  // Pattern matching on case class instances
  alice match {
    case Person("Alice", age) => println(s"Hello, Alice! Your age is $age")
    case _ => println("Unknown person")
  }

  // Using the copy method to create a modified instance
  val olderAlice = alice.copy(age = 31)
  println(olderAlice) // Output: Person(Alice, 31)

  // Define a case class
  case class Point(x: Int, y: Int)

  // Create an instance of the case class
  val point = Point(5, 10)

  // Serialize the case class instance to a byte array
  val serializedObject = serialize(point)

  // Deserialize the byte array back into an object
  val deserializeObject = deserialize(serializedObject)

  // Check if deserialization was successful
  deserializeObject match {
    // Some represents may or may not exists
    case Some(p: Point) =>
      println(s"Deserialized point: $p")
    case _ =>
      println("Deserialization failed.")
  }

  def serialize(obj: Serializable): Array[Byte] = {
    val byteArrayOutputStream = new ByteArrayOutputStream()
    val objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)
    objectOutputStream.writeObject(obj)
    objectOutputStream.close()
    byteArrayOutputStream.toByteArray
  }

  def deserialize(bytes: Array[Byte]): Option[Serializable] = {
    Try {
      val byteArrayInputStream = new ByteArrayInputStream(bytes)
      val objectInputStream = new ObjectInputStream(byteArrayInputStream)
      val obj = objectInputStream.readObject()
      byteArrayInputStream.close()
      obj.asInstanceOf[Serializable]
    }.toOption
  }

  // Option[T]
  val someTest: Option[Int] = Some(42)
  println(someTest)
  val nonTest: Option[Int] = None
  println(nonTest)
}
