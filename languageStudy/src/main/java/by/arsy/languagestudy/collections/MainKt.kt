package by.arsy.languagestudy.collections

fun main() {
    studyList()
    studyMap()
}

private fun studyList() {
    println("Study \"List\":")
    val numbers = mutableListOf(1, 3, 5, 2, 4, 6, 4, 3)

    println(numbers)
    println(numbers.size)
    println(numbers.contains(99))

    numbers.add(98)
    numbers.add(99)

    println(numbers)
    println(numbers.size)
    println(numbers.contains(98))
    val indexOf98 = numbers.indexOf(98)
    println(indexOf98)

    numbers.removeAt(indexOf98)
    numbers.remove(element = 99)
    numbers.removeLast()
    numbers.removeFirst()

    println(numbers)
    println(numbers.size)
}

private fun studyMap() {
    println("Study \"Map\":")
    val products = mutableMapOf(
        "orange" to 100,
        "apple" to 50,
        "banana" to 60
    )

    println(products)

    products["bread"] = 30
    println(products)
    println(products["bread"])

    products.remove(key = "bread")
    println(products)
}