package by.arsy.languagestudy.collections

fun main() {
    val numbers = createList()
    println(uniqueNumbers(numbers))
    println(countOfRepeatsForEachNumber(numbers))
}


private fun createList(): List<Int> {
    val numbers = listOf(1, 4, 6, 5, 4, 3, 2, 3, 5, 3, 4)
    println(numbers)
    return numbers
}

private fun uniqueNumbers(numbers: List<Int>) : Set<Int> = numbers.toSet()

private fun countOfRepeatsForEachNumber(numbers: List<Int>) : Map<Int, Int> {
    val countOfRepeatsForEachNumber = mutableMapOf<Int, Int>()
    numbers.forEach {
        val count = countOfRepeatsForEachNumber.getOrDefault(it, 0)
        countOfRepeatsForEachNumber[it] = count + 1
    }
    return countOfRepeatsForEachNumber
}