package by.arsy.languagestudy

open class Employee {
    fun work() {
        println("The employee is working...")
    }
    open fun haveLunch() {
        println("The employee is having lunch...")
    }
    open fun goHome() {
        println("The employee is going home...")
    }
}

class Programmer : Employee() {
    override fun haveLunch() {
        super.haveLunch()
        println("and drinking coffee like programmer")
    }
}

class Designer : Employee() {
    override fun goHome() {
        println("The designer is heading to his beautiful home.")
    }
}

// TODO здесь можно создать новый класс, который будет наследоваться от класса Employee. Не забудьте переопределить методы haveLunch() и goHome()