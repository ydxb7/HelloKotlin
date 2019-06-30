package Aquarium

fun main(args: Array<String>){
//    delegate()

    println(GoldColor)
    val pleo = Plecostomus2()
    println(pleo)


}

fun delegate(){
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction{
    fun eat()
}

interface FishColor{
    val color: String
}

class Plecostomus1: FishAction, FishColor{
    override fun eat() {
        println("eat algae")
    }

    override val color: String
        get() = "gold"
}

object GoldColor: FishColor{
    override val color = "gold"
}

class Plecostomus2(fishColor: FishColor = GoldColor): FishAction, FishColor by fishColor{
    override fun eat() {
        println("eat algae")
    }
}

class PrintingFishAction(val food: String): FishAction{
    override fun eat() {
        println(food)
    }
}

class Plecostomus(fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("a lot of algae"),
    FishColor by fishColor
