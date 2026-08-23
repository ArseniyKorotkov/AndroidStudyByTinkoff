package by.arsy.languagestudy.generic

fun main() {
    useDifferentClasses()
    useGeneric()
}

class PairInt(val first: Int, val second: Int)
class PairString(val first: String, val second: String)

private fun useDifferentClasses() {
    val intPair = PairInt(1,2) // Pair<Int>
    val stringPair = PairString("hello", "world") // Pair<String>
}

class Pair<T>(val first: T, val second: T)

private fun useGeneric() {
    val intPair = Pair(1, 2) // Pair<Int>
    val stringPair = Pair("hello", "world") // Pair<String>
    val userPair = Pair(User("Alice"), User("Bob")) // Pair<User>
    // and more ...
}
// generic example: one class


class User(val name: String)