package Aquarium.Decorations

const val rocks = 3 // the value is always determined at compile time
val number = 5  // the value that is assigned can be determined during program execution

const val CONSTANT = "top-level constant"

object Constants {
    const val CONSTANT2 = "object constant"
}

val foo = Constants.CONSTANT2

class MyClass{

    companion object{
        const val CONSTANT3 = "constant inside companion"
    }
}


fun main(args: Array<String>) {


}