package by.arsy.languagestudy

class Person(val name: String) {
    private val _accounts: MutableList<DepositAccount> = mutableListOf()
    val accounts: List<DepositAccount> = _accounts

    constructor(personName: String, depositName: String) : this(personName) {
        this._accounts.add(
            DepositAccount(depositName)
        )
    }
}