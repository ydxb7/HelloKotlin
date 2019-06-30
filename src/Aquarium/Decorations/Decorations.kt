package Aquarium.Decorations

fun main(args: Array<String>){
    makeDecorations()
}

fun makeDecorations(){
    val d1 = Decorations("granite")
    println(d1)

    val d2 = Decorations("slate")
    println(d2)

    val d3 = Decorations("slate")
    println(d3)

    println(d1.equals(d2))
    println(d3.equals(d2))

    val d4 = d3.copy()
    println(d4)

    val d5 = Decorations2("crystal", "wood", "diver")
    println(d5)

    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)

    println(Color.RED)
    println(Color.GREEN.rgb)
    println(Color.BLUE.rgb)




}



data class Decorations(val rocks: String){}

data class Decorations2(val rocks: String, val wood: String, val diver: String){}

object MobyDickWhale{

    val author = "HM"
    fun jump(){
        // ...
    }
}

enum class Color(val rgb: Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

sealed class Seal

class SeaLion: Seal()
class Walrus: Seal()

fun matchSeal(seal: Seal): String{
    return when(seal){
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}
