package by.arsy.languagestudy

lateinit var text: String

fun main() {
    val name = "Arseni"
    text = "${getTextHello()} $name"
    printHello(text)
}

fun printHello(text: String) {
    println(text)
}

fun getTextHello(): String {
    return "Hello"
}