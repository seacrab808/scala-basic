package lecture

object Generics extends App {
  // Generic class
  class MyContainer[T](value: T) {
    def getContent: T = value
  }

  // Create instances of MyContainer with different types
  val intContainer = new MyContainer(42)
  val stringContainer = new MyContainer("Hello, Scala!")

  val intValue: Int = intContainer.getContent
  println(intValue)
  val stringValue: String = stringContainer.getContent
  println(stringValue)

  // Generic method
  class MyList {
    def makeTuple[A, B](first: A, second: B): (A, B) = {
      (first, second)
    }
  }

  val myList = new MyList

  val intStringTuple = myList.makeTuple(42, "Hello")
  print(intStringTuple)
  val doubleBooleanTuple = myList.makeTuple(3.14, true)
  print(doubleBooleanTuple)

  // Convariance
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  class AnimalContainer1[+T](value: T)
  val dogContainer1: AnimalContainer1[Animal] = new AnimalContainer1[Dog](new Dog)

  // Invariance
  class AnimalContainer2[T](value: T)
  val animalContainer2: AnimalContainer2[Animal] = new AnimalContainer2[Animal](new Animal)
  val dogContainer2: AnimalContainer2[Dog] = new AnimalContainer2[Dog](new Dog)

  // Contravariance
  class AnimalContainer3[-T](value: T)
  val dogContainer3: AnimalContainer3[Dog] = new AnimalContainer3[Animal](new Animal)

  // Bounds Type
  class Container[T <: Animal](value: T) {
    // This container can hold animals or their subtypes
    def getAnimal: T = value
  }

  class PetContainer[T >: Dog](pet: T) {
    // This container can hold pets or their supertypes (e.g., Animal)
    def getPet: T = pet
  }

  val animalContainer = new Container(new Dog)
  println(animalContainer.getAnimal)
  val catContainer = new Container(new Cat)
  println(catContainer.getAnimal)

  val dogContainer = new PetContainer(new Dog)
  println(dogContainer.getPet)
  val animalPetContainer = new PetContainer(new Animal)
  println(animalPetContainer.getPet)
}
