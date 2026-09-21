package by.arsy.androidstudybytinkoff.presentation

data class ShopListItem(
    val id: Int = UNDEFINED_ID,
    val name: String,
    val count: Int,
    val enabled: Boolean
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}