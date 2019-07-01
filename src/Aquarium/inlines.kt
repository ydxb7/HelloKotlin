package Aquarium

fun main(args: Array<String>) {

    data class Fish(var name: String)

    val fish = Fish("splash")



    myWith(fish.name) {
        capitalize()
    }

    myWith(fish.name, object : Function1<String, Unit>{
        override fun invoke(name: String){
            println(name.capitalize())
            name.capitalize()
        }
    })

    fish.name.capitalize()

}

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}


