package by.arsy.languagestudy.oop.encapsulation

fun main() {
    val humanAnton = Human("Anton", 20)
    val antonAccount = Account(
        owner = humanAnton,
        currency = "RUB",
        amount = 50000
    )

// Protected by encapsulation
//    antonAccount.owner = newOwner
//    antonAccount.amount = 1000000000

// Right use
    antonAccount.take(500)


}