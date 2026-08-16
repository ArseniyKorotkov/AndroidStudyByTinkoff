package by.arsy.languagestudy

fun main() {
    val person = Person(name = "Alex")
    val person2 = Person(
        personName = "Sam",
        depositName = "main"
    )

    printPerson(person)
    printPerson(person2)
}

fun printPerson(person: Person) {
    val size = person.accounts.size
    print("Person ${person.name} has $size deposits")
    if (size > 0) {
        print(", for example '${person.accounts.first().name}' deposit")
    }
    println()
}


