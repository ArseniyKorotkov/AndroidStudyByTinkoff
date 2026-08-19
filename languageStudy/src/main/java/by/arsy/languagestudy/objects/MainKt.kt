package by.arsy.languagestudy.objects

fun main() {
    println(MySingleton.myValue)
    MySingleton.doSomething()
}

interface MyInterface {
    fun doSomething()
}

open class MySuperClass {
    open val myValue: Int = 42
}

object MyInheritanceSingleton : MySuperClass(), MyInterface {
    override val myValue = 42

    override fun doSomething() {
       println("Вызываем метод у синглтона")
    }
}
object MySingleton {
    val myValue = 42

    fun doSomething() {
       println("Вызываем метод у синглтона")
    }
}

