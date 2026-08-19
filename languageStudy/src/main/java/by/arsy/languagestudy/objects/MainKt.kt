package by.arsy.languagestudy.objects

fun main() {
    println(MySingleton.myValue)
    MySingleton.doSomething()

    println(MyCoolClass.name)
    MyCoolClass.create()

    val helloWorld = object : MyInterface {
        val hello = "Hello"
        val world = "World"
        override fun toString() = "$hello $world"
        override fun doSomething() {
            TODO("Not yet implemented")
        }
    }

    fun getSomething() = object {
        val d = 7

        fun getDoubledNum() = d * 2
    }
    println(getSomething().d)
    println(getSomething().getDoubledNum())

    calculate(object : MyInterface{
        override fun doSomething() {
            TODO("Not yet implemented")
        }

    })
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

class MyCoolClass {
    companion object {
        val name = "Имя"

        fun create() : MyCoolClass {
            println("create MyCoolClass")
            return MyCoolClass()
        }
    }
}

fun calculate(obj: MyInterface) {
    obj.doSomething()
}

