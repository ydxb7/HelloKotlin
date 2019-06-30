package Aquarium

import kotlin.math.PI

fun main(args: Array<String>){

    val equipment = "fishnet" to "catching fish"
    val (tool, use) = equipment
    println("The $tool is a tool for $use")

    val equipmentString = equipment.toString()
    println(equipmentString)

    val equipmentList = equipment.toList()
    println(equipmentList)


    val (a, b, c) = Triple(2, "x", listOf(null))
    println(a) // 2
    println(b) // x
    println(c) // [null]

//    println(equipment)

//    println(equipment.first.first)

//    println(equipment.second)

    println(giveMeATool())


//    val a1 = Aquarium()
//    println(a1)
//
//    val a2 = TowerTank()
//    println(a2)
//
//    val a3: Aquarium = a2 as Aquarium
//    println(a3)

}

fun giveMeATool(): Pair<String, String>{
    return ("fishnet" to "catching")
}


open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {height = (value * 1000) / (width * length)}

    open var water = volume * 0.9

    constructor(numberOfFish: Int): this(){
        val water: Int = numberOfFish * 2000
        val tank: Double = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }
}

class TowerTank(): Aquarium(){
    override var water = volume * 0.8

    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {height = (value * 1000) / (width * length)}
}