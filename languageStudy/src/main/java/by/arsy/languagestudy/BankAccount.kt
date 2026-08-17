package by.arsy.languagestudy

abstract class BankAccount(val bankAccountName: String = "default") {

    abstract fun getAvailableFunds(): Double

    abstract fun withdrawMoney(amount: Double): Double

    abstract fun depositMoney(amount: Double)

    fun info() {
        println("Deposit name is '$bankAccountName'")
    }
}