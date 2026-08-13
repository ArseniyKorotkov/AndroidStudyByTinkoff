package by.arsy.languagestudy

lateinit var text: String

fun main() {
    text = getTextHello()
    printHello(text)
}

fun printHello(text: String) {
    println(text)
}

fun getTextHello(): String {
    return "Hello"
}