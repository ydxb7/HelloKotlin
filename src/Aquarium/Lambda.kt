package Aquarium

fun main(args: Array<String>) {

    { println("Hello Fish") }()

    data class Fish(val name: String)

    val myFish = listOf(Fish("Flipper"), Fish("Moby Dick"), Fish("Dory"))

    myFish.filter { it.name.contains("i") }.joinToString(" ") { it.name }

    val symptoms = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly up")
    symptoms.joinToString("!") { it }    // white spots!red spots!not eating!bloated!belly up

}