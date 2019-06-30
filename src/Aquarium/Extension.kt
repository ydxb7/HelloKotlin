package Aquarium

import java.io.File

fun String.hasSpaces() = find { it == ' ' } != null


fun main(args: Array<String>) {

//    val s1 = "abcd ef"
//    println(s1.hasSpaces()) // true
//    println("abcdef".hasSpaces()) // false
//
//    val plant = GreenLeafyPlant(size = 50)
//    plant.print()  // GreenLeafyPlant
//
//    val aquariumPlant: AquariumPlant = plant
//    aquariumPlant.print()  // AquariumPlant
//    val plant = AquariumPlant("Green", 50)
//    plant.isGreen  // true


    val plant: AquariumPlant? = null
    val plant2: AquariumPlant? = AquariumPlant("Green", 50)
    plant.pull()  // 什么都没有返回
    plant2.pull() // removing Aquarium.AquariumPlant@65ab7765

}

class AquariumPlant(val color: String, private val size: Int)

val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun AquariumPlant?.pull(){
    this?.apply {
        println("removing $this")
    }
}



//class GreenLeafyPlant(size: Int): AquariumPlant("Green", size)
//
//fun AquariumPlant.isRed() = color == "Red"
//
//fun AquariumPlant.print() = println("AquariumPlant")
//fun GreenLeafyPlant.print() = println("GreenLeafyPlant")


