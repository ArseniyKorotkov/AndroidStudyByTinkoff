package by.arsy.languagestudy

fun main() {
    val teacher1 = Teacher(
        name = "Nicholas",
        age = 35,
        progExperience = 10,
        languages = listOf("Kotlin", "Java")
    )
    val teacher2 = Teacher(
        name = "Nicholas",
        age = 35,
        progExperience = 10,
        languages = listOf("Kotlin", "Java")
    )

    println(teacher1 == teacher2) // equals() and hashCode()

    val olderTeacher = teacher1.copy(age = 48) // copy()
    println(olderTeacher) // toString()

    val (name, age) = olderTeacher
    println("$name, $age")
}

