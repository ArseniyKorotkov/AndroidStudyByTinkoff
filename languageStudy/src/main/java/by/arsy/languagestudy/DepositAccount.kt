package by.arsy.languagestudy

class DepositAccount(val name: String = "default") {

    private var availableFunds: Double = 790_000.0

    fun getAvailableFunds(): Double {
        return availableFunds
    }

    fun withdrawMoney(amount: Double): Double {
        return if (amount > 0 && amount <= availableFunds) {
            availableFunds -= amount
            amount
        } else {
            0.0
        }
    }

    fun depositMoney(amount: Double) {
        if (amount > 0) {
            availableFunds += amount
            println("$amount success added to $name")
        } else {
            println("Exception: amount must be positive")
        }
    }
}