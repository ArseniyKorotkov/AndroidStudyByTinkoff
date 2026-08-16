package by.arsy.languagestudy

fun main() {
    val employee = Employee()
    val programmer = Programmer()
    val designer = Designer()

    employee.work()
    programmer.work()

    employee.haveLunch()
    programmer.haveLunch()

    programmer.goHome()
    designer.goHome()
}

