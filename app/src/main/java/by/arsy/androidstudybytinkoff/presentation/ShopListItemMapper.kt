package by.arsy.androidstudybytinkoff.presentation

import by.arsy.androidstudybytinkoff.domain.ShopItem

class ShopListItemMapper {

    fun map(item: ShopItem): ShopListItem {
        return with(item) {
            ShopListItem(
                id = id,
                name = name,
                count = count,
                enabled = enabled,
            )
        }
    }
}