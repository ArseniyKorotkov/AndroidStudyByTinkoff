package by.arsy.languagestudy

fun main() {
    val a = 10
    val b = 3
    println("max long = ${Long.MAX_VALUE}")
    println("max int = ${Int.MAX_VALUE}")
    print("\n\n")
    plus(Int.MAX_VALUE, Int.MAX_VALUE)
    minus(a, b)
    multiply(a, b)
    divide(a, b)
}

fun plus(a: Int, b: Int) {
    println("$a + $b = ${a + b} !!!!!")
    println("right: $a + $b = ${a.toLong() + b}\n")
}
fun plus(a: Long, b: Long) {
    println("$a + $b = ${a + b} !!!!!")
}
fun minus(a: Int, b: Int) {
    println("$a - $b = ${a - b}\n")
}
fun multiply(a: Int, b: Int) {
    println("$a * $b = ${a * b}\n")
}
fun divide(a: Int, b: Int) {
    println("$a / $b = ${a / b} !!!!!")
    println("right: $a / $b = ${a.toDouble() / b}\n")
}