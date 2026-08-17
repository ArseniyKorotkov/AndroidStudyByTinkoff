package by.arsy.languagestudy

data class Teacher(
    val name: String,
    val age: Int,
    val progExperience: Int,
    val languages: List<String>
)

data class Language(val name: String)
