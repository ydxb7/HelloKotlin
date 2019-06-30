package Aquarium.generics

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addhemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

class Aquarium1<T>(val waterSupply: T)
class Aquarium2<T: Any?>(val waterSupply: T)
class Aquarium3<T: Any>(val waterSupply: T)
class Aquarium<T: WaterSupply>(val waterSupply: T){
    fun addWater(){
        check(!waterSupply.needsProcessed){"water supply needs processed"}
        println("adding water from $waterSupply")
    }
}


fun main(args: Array<String>) {

    val aquarium = Aquarium(TapWater())
//    aquarium.waterSupply.addhemicalCleaners()
    println(aquarium.waterSupply.needsProcessed)
    aquarium.addWater()

}