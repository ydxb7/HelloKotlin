import Aquarium.Aquarium
import Aquarium.TowerTank
import Aquarium.Fish
import Aquarium.Plecostomus
import Aquarium.FishAction

import java.lang.Math.random
import java.util.*

fun main (args: Array<String>){
//    println("Hello, ${args[0]}!")
//    buildAquarium()
//    val fish = Fish(true, 20)
//
//    val myTowerTank = TowerTank()
//    println("myTowerTank water = ${myTowerTank.water}")
//    println("myTowerTank volume = ${myTowerTank.volume}")
//    makeFish()

}

fun feedFish(fish: FishAction){
    fish.eat()
}

//fun makeFish(){
//    val shark = Shark()
//    val pleco = Plecostomus()
//
//    println("Shark: ${shark.color} \n Plecostomus: ${pleco.color}")
//
//    shark.eat()
//    pleco.eat()
//    feedFish(shark)
//    feedFish(pleco)
//}





fun buildAquarium(){
    val myAquarium = Aquarium()

    println("length: ${myAquarium.length}")
    println("height: ${myAquarium.height}")
    println("width: ${myAquarium.width}")

    val myAquarium2 = Aquarium(numberOfFish = 9)

}





var dirty = 20
//val waterFilter1 = {dirty: Int -> dirty / 2}
//val a = waterFilter1(20)

val waterFilter: (Int) -> Int = {dirty -> dirty / 2}
fun feedFish(dirty: Int) = dirty + 10

// higher-order function: takes function as a parameter
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor(){
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty){dirty -> dirty + 50}
    dirty = updateDirty(dirty, {dirty -> dirty + 50})
}



fun eagerExample(){
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    val eager = decorations.filter { it[0] == 'p' }
    println(eager)

    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())

    val lazyMap = decorations.asSequence().map{
        println("map: $it")
        it
    }
    println(lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")
}

fun dayOfWeek(){
    println("What day is it today?")
    val today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    var todayDate = when (today){
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        else -> "Saturday"
    }

    println("Today is $todayDate")

    swim(50, speed = "slow")
    swim(50, "slow")
    swim(50)

    repeat(2){
        println("new line")
    }
}

fun swim(time: Int, speed: String = "fast"){
    println("swimming $speed")
}