import java.lang.ref.WeakReference

// 考点：WeakReference和GC（garbage collation）
// 重要程度类是于corner stone，senior必考

typealias SignalCompletion<T> = (T) -> Unit

open class Signal<T> {
    var weakObserver: WeakReference<Any?>? = null
    var weakCallback: WeakReference<SignalCompletion<T>?>? = null
//    var weakCallback: SignalCompletion<T>? = null

    fun <Caller : Any> subscribeWith(observer: Caller, callback: SignalCompletion<T>?) {
        weakObserver = WeakReference(observer)
        weakCallback = WeakReference(callback)
//        weakCallback = callback
    }

    open fun fire(data: T) {
        weakCallback?.get()?.invoke(data)
//        weakCallback?.invoke(data)
    }
}

var signal = Signal<String>()

class SomeClass {
    private var someVar: String? = " [SomeClass]: hello world!"

    init {

        signal.subscribeWith(this) {

            println("inx someclass callback: $it, getClass:,")
//            println("inx someclass callback: $it, getClass:,$someVar")
        }
    }
}
fun testSignal() {
    println("=================== testSignal start ")
    var someClass: SomeClass? = SomeClass()

    println("observer is null: ${signal.weakObserver?.get() != null}")
    println("callback is null: ${signal.weakCallback?.get() != null}")

    signal.fire("hello 1")

    println("force gc when someClass is not null")
    forceGC()

    signal.fire("hello 2")

    someClass = null
    println("force gc when someClass is null")

    forceGC()

    println("observer is null: ${signal.weakObserver?.get() != null}")
    println("callback is null: ${signal.weakCallback?.get() != null}")

    signal.fire("world")
    println("callback is null: ${signal.weakCallback?.get() != null}")
    signal.fire("world")
    println("=================== testSignal end ")
}

fun forceGC() {
    println("Force GC")
    System.gc()
    Runtime.getRuntime().gc()
}

fun main(args: Array<String>) {
    testSignal()
}
