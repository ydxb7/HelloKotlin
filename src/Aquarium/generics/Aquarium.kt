package Aquarium.generics
fun main(args: Array<String>) {

    val aquarium = Aquarium(TapWater())
    val cleaner = TapWaterCleaner()
    aquarium.addWater(cleaner)

    addItemTo(aquarium)

    isWaterClean<TapWater>(aquarium)
    isWaterClean(aquarium)

    aquarium.hasWaterSupplyOfType<TapWater>() // true
    println(aquarium.hasWaterSupplyOfType<TapWater>()) // true

    aquarium.waterSupply.isOfType<LakeWater>() // false
    println(aquarium.waterSupply.isOfType<LakeWater>()) // false
}
inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>){
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addhemicalCleaners() {
        needsProcessed = false
    }
}


class Aquarium<out T: WaterSupply>(val waterSupply: T){
    fun addWater(cleaner: Cleaner<T>){
        if(waterSupply.needsProcessed){
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }


}

interface Cleaner<in T: WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater) {
        waterSupply.addhemicalCleaners()
    }
}


//class FishStoreWater : WaterSupply(false)
//
//class LakeWater : WaterSupply(true) {
//    fun filter() {
//        needsProcessed = false
//    }
//}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")



