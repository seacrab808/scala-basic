package lecture

object StringManipulation extends App {
  // String Concatenation
  val firstName = "John"
  val lastName = "Doe"
  val fullName = firstName + " " + lastName
  println(fullName) // Output: John Doe

  // String Interpolation
  // s: Interpolates values into a string using ${}
  val age = 30
  val message = s"My age is $age"
  println(message) // Output: My age is 30

  // f: Allows you to format strings using placeholders
  val pi = 3.14159
  val formatted = f"Pi is approximately $pi%4.2f"
  println(formatted) // Output: Pi is approximately 03.14

  // raw: Treats the string content as raw, without interpreting escape sequences
  val rawStr = raw"This is a \n raw string."
  println(rawStr) // Output: This is a \n raw string.

  // String Methods
  // length: Get the length of a string
  val text = "Scala is fun!"
  val length = text.length
  println(length) // Output: 13

  // charAt(index: Int): Returns the character at the specified index.
  val char = text.charAt(0)
  println(char) // Output: S

  // substring(start: Int, end: Int): Extracts a substring from the given string,
  //  starting from the start index (inclusive) to the end index (exclusive).
  val subStr = text.substring(0, 5)
  println(subStr) // Output: Scala

  // toUpperCase and toLowerCase: Convert a string to uppercase or lowercase.
  val upper = text.toUpperCase
  val lower = text.toLowerCase
  println(upper) // Output: SCALA IS FUN!
  println(lower) // Output: scala is fun!

  // split(separator: String): Splits a string into an array of substrings based on the specified separator.
  val words = text.split(" ")
  println(words.mkString(", ")) // Output: Scala, is, fun!

  // startsWith(prefix: String) and endsWith(suffix: String):
  //  These methods check if a string starts with the specified prefix
  //  or ends with the specified suffix, respectively.
  val startsWithScala = text.startsWith("Scala")
  val endsWithFun = text.endsWith("fun!")
  println(startsWithScala) // Output: true
  println(endsWithFun) // Output: true

  // contains(substring: String): Checks if a string contains the specified substring.
  val str1 = "Hello, Scala!"
  val containsScala = str1.contains("Scala")
  println(containsScala) // Output: true

  // trim: Removes leading and trailing whitespace characters from a string.
  val str2 = "    Scala is fun!  "
  val trimmed = str2.trim
  println(trimmed) // Output: Scala is fun!

  // indexOf(substring: String) and lastIndexOf(substring: String):
  // These methods find the index of the occurrence and
  // the last occurrence of a substring within a string, respectively
  val str3 = "Hello, Scala, and Scala is fun!"
  val firstIndex = str3.indexOf("Scala")
  println(firstIndex) // Output: 7
  val lastIndex = str3.lastIndexOf("Scala")
  println(lastIndex) // Output: 18

  // replace(oldStr: string, newStr: String):
  //  Replaces all occurrences of oldStr with newStr in the string.
  val str4 = "Hello, Scala!"
  val replaced = str4.replace("Scala", "Java")
  println(replaced) // Output: Hello, Java!

}
