package by.arsy.languagestudy.enumClass

fun main() {
    val status = getPurchaseStatus(PurchaseStatus.IN_PROGRESS)
    println(status)

    val readyStatus = getPurchaseReadyStatus(PurchaseStatus.IN_PROGRESS)
    println(readyStatus)

    println(PurchaseStatus.entries)

    println(PurchaseStatus.IN_PROGRESS.ordinal)
    println(PurchaseStatus.READY.ordinal)

    PurchaseStatus.READY.printId()
}

fun getPurchaseStatus(status: PurchaseStatus): String {
    return when (status) {
        PurchaseStatus.IN_PROGRESS -> "доставка в процессе"
        PurchaseStatus.READY -> "доставка готова"
        PurchaseStatus.CANCELED -> "доставка отменена"
    }
}

fun getPurchaseReadyStatus(status: PurchaseStatus): String {
    return when (status) {
        PurchaseStatus.READY -> "доставка готова"
        else -> "доставка не готова"
    }
}