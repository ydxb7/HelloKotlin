//package Aquarium
//
//fun main(args: Array<String>) {
//
//    { println("Hello Fish") }()
//
//    data class Fish(var name: String)
//
//    val fish = Fish("splashy")
//
//    with(fish.name) {
//        capitalize()  // Splashy
//    }
//
//    myWith(fish.name) {
//        println(capitalize())
//    }
//
//
//
//    println("run:")
//    println(fish.run { name.capitalize() })   // Splashy
//    println(fish.run { name.capitalize() }.run { this + "fish" })   // Splashyfish
//
////    println(fish.apply { name = name.capitalize() })  // Fish(name=Splashy)
//
//    println("let:")
//
//    println(fish.let { it.name.capitalize() })    // Splashy
//    println(fish.let { it.name.capitalize() }.let { it + "fish" })   // Splashyfish
//    println(fish.let { it.name.capitalize() }.let { it + "fish" }.let { it.length })   // 11
//    println(fish.let { it.name.capitalize() }.let { it + "fish" }.let { it.length }.let { it + 31 })   // 42
//
//
//
//
////    val myFish = listOf(Fish("Flipper"), Fish("Moby Dick"), Fish("Dory"))
////
////    myFish.filter { it.name.contains("i") }.joinToString(" ") { it.name }
////
////    val symptoms = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly up")
////    symptoms.joinToString("!") { it }    // white spots!red spots!not eating!bloated!belly up
//
//}
//
//
//fun myWith(name: String, block: String.() -> Unit) {
//    name.block()
//}
//
