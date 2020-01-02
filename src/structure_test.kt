open class Assertion
open class Action<T1 : Assertion, T2: Action<T1, T2>> {
    fun check(assertion: T1): T2 {
        return this as T2
    }
}

class MyAssertion : Assertion() {
    fun myAssertion(): MyAssertion {
        println("checking myAssertion.")
        return this
    }
}

class MyAction : Action<MyAssertion, MyAction>(){
    fun action(): MyAction{
        println("some action.")
        return this
    }
}


fun main(args: Array<String>) {
    MyAction()
        .action()
        .check(MyAssertion().myAssertion())
        .action()

}