package by.arsy.languagestudy.sealedClass

fun main() {
    val status = getPurchaseStatus(PurchaseStatus.InProgress)
    println(status)

    val readyStatus = getPurchaseReadyStatus(PurchaseStatus.InProgress)
    println(readyStatus)
}

fun getPurchaseStatus(status: PurchaseStatus): String {
    return when (status) {
        PurchaseStatus.InProgress -> "доставка в процессе"
        PurchaseStatus.Ready -> "доставка готова"
        is PurchaseStatus.Canceled -> "доставка отменена по присине ${status.reason}"
    }
}

fun getPurchaseReadyStatus(status: PurchaseStatus): String {
    return when (status) {
        PurchaseStatus.Ready -> "доставка готова"
        else -> "доставка не готова"
    }
}