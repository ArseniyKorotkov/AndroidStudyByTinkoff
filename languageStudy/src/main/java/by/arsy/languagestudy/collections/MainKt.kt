package by.arsy.languagestudy.collections

fun main() {
    collectionOperations()

    chainOfCollectionOperations()

    asSequenceOperation()
}

private fun collectionOperations() {
    println("Collection operations:")
    val numbers = createList()
    val mappedNumbers = numbers.map { "Number: $it" }
    println(mappedNumbers)
    val listOfLists = listOf(numbers, mappedNumbers)
    println(listOfLists)
    println(listOfLists.flatten())
    println(numbers.filter { it % 2 == 0 })
    println(numbers.sorted())
}

private fun chainOfCollectionOperations() {
    println("Chain of collection operations:")
    val numbers = listOf(listOf(5, 2, 4), listOf(1, 0, 8), listOf(99, 2, 100))
    println(
        numbers
            .flatten()
            .filter { it < 5 }
            .sorted()
            .map { "строка: $it" }
    )
}

private fun asSequenceOperation() {
    println("As sequence collection operation:")
    val numbers: List<Int> = listOf(0, 1, 2, 3, 4, 5, 6, 7)

    testChain(numbers)
    testChain(numbers.asSequence())
}

private fun testChain(list: List<Int>) {
    var operationsCount = 0

    list.filter {
            println("filter: $it")
            operationsCount++
            it < 5 && it % 2 == 0
        }
        .map {
            println("map: $it")
            operationsCount++
            "строка: $it"
        }
        .take(2)
        .toList()
    println("List operations count: $operationsCount")
}
private fun testChain(sequence: Sequence<Int>) {
    var operationsCount = 0

    sequence.filter {
            println("filter: $it")
            operationsCount++
            it < 5 && it % 2 == 0
        }
        .map {
            println("map: $it")
            operationsCount++
            "строка: $it"
        }
        .take(2)
        .toList()
    println("Sequence operations count: $operationsCount")
}

private fun createList(): List<Int> {
    val numbers = listOf(1, 4, 6, 5, 4, 3, 2, 3, 5, 3, 4)
    println(numbers)
    return numbers
}