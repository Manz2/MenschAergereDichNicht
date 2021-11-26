trait Animal {
 def run = println("animal running")
}
private class Dog extends Animal {
 override def run: Unit = println("dog running")
}
private class Cat extends Animal {
 override def run: Unit = println("cat running")
}
object Animal {
 def apply(kind: String) = kind match {
   case "dog" => new Dog()
   case "cat" => new Cat()
 }
}
val animal = Animal("dog")
animal.run
