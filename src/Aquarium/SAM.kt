package Aquarium

fun main(args: Array<String>) {

//    val runnable = object : Runnable2 {  // 继承 Runnable
//        override fun run() {
//            println("I'm a runnable")
//        }
//    }
//    JavaRun.runNow(runnable)


//    JavaRun.runNow {
//        println("Passing a lambda as a runnable")
//    }

//    test{
//        println("Passing a lambda")
//    }

//    test{
//        println("Pass")
//    }

    val runnable = object : myRunnable {  // 继承 Runnable
        override fun run() {
            println("I'm a runnable")
        }
    }
    test(runnable)

//    test{ println("running")}


}


interface myRunnable {
    fun run()
}

fun test(runnable: myRunnable){
    runnable.run()
}





