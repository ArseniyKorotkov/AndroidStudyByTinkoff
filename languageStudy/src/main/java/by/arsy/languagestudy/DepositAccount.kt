package by.arsy.languagestudy

class DepositAccount(val name: String = "default") : BankAccountInterface {

    override val bankAccountName: String
        get() = name
    private var availableFunds: Double = 790_000.0

    override fun getAvailableFunds(): Double {
        return availableFunds
    }

    override fun withdrawMoney(amount: Double): Double {
        return if (amount > 0 && amount <= availableFunds) {
            availableFunds -= amount
            amount
        } else {
            0.0
        }
    }

    override fun depositMoney(amount: Double) {
        if (amount > 0) {
            availableFunds += amount
            println("$amount success added to $bankAccountName")
        } else {
            println("Exception: amount must be positive")
        }
    }
}