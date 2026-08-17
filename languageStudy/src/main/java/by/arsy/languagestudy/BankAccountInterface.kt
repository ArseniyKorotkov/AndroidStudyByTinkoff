package by.arsy.languagestudy

interface BankAccountInterface {

    val bankAccountName: String
    fun getAvailableFunds(): Double

    fun withdrawMoney(amount: Double): Double

    fun depositMoney(amount: Double)

    fun info() {
        println("Deposit name is '$bankAccountName'")
    }
}