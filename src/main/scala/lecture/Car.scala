package lecture

class Car {
   var model: String = "modelY"
   var year: Int = 2023

   // Primary constructor
   def this(model: String, year: Int) = {
     this() // Call the primary constructor first
     this.model = model
     this.year = year
   }

   // Auxiliary constructor with only a model parameter
   def this(model: String) = {
     this() // Call the primary constructor first
     this.model = model
   }

   // Auxiliary constuctor with only an year parameter
   def this(year: Int) = {
     this() // Call the primary constructor first
     this.year = year
   }

  def introduce(): Unit = {
    println(s"${this.model}(${this.year}) is starting...")
  }
}
