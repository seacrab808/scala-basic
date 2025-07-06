package lecture

object Enum extends App {
  enum Color {
    case Red, Green, Blue
  }

  // Access Enum
  println(Color.Red)
 // Access with String
  println(Color.valueOf("Red"))
  // Access the position
  println(Color.Red.ordinal)
  //List all the enum values
  Color.values.foreach(color => println(color))

  // enum with constructor
  enum Planet(val mass: Double, radius: Double) {
    case Earth extends Planet(5.97e24, 6.379e6)
    case Mars extends Planet(6.39e23, 3.389e6)
    // other planets..
  }
  println(Planet.Earth.mass)

  // enum can have method
  enum Shape {
    case Circle(radius: Double)
    case Rectangle(width: Double, height: Double)

    def area: Double = this match {
      case Circle(r) => Math.PI * r * r
      case Rectangle(w, h) => w * h
    }
  }
  val shape: Shape = Shape.Circle(10)
  println(shape.area)
}
