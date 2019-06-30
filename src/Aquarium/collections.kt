package Aquarium

fun main(args: Array<String>){
    val testList = listOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    println(reverseList(testList))
    println(testList.reversed())

    val symptoms = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly up")

    symptoms.add("white fungus")
    symptoms.remove("white fungus")

    symptoms.contains("red") // false
    symptoms.contains("red spots") // true

    println(symptoms.subList(4, symptoms.size)) // [belly up]
    listOf(1, 5, 3).sum() // 9

    listOf("a", "b", "cc").sumBy { it.length } // 4


    val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")
    println(cures.get("white spots")) // Ich
    println(cures["white spots"])    // Ich

    println(cures.getOrDefault("bloating", "sorry I don't know"))
    println(cures.getOrElse("bloating") { "No cure for this" })
    println(cures.getOrElse("white spots") { "No cure for this" })

    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    inventory.remove("fish net")


}

fun reverseList(list: List<Int>): List<Int>{
    val result = mutableListOf<Int>()
    for(i in list.size - 1 downTo 0){
        result.add(list.get(i))
    }
    return result
}