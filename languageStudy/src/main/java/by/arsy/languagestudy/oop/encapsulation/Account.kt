package by.arsy.languagestudy.oop.encapsulation

class Account(
    val owner: Human,
    val currency: String,
    private var amount: Int
) {
    fun topUp(sum: Int) {
        amount += sum
    }
    fun take(sum: Int) {
        amount -= sum
    }
}