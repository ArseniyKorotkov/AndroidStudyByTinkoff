package by.arsy.languagestudy.enumClass

enum class PurchaseStatus(val id: Int) {
    IN_PROGRESS(1),
    READY(2),
    CANCELED(3);

    fun printId() {
        println("$name has id=$id")
    }
}