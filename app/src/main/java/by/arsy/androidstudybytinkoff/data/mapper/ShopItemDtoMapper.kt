package by.arsy.androidstudybytinkoff.data.mapper

import by.arsy.androidstudybytinkoff.data.entity.ShopItemDTO
import by.arsy.androidstudybytinkoff.data.entity.ShopItemDbModel
import by.arsy.androidstudybytinkoff.domain.ShopItem

class ShopItemDtoMapper {

    fun map(dto: ShopItemDTO): ShopItem {
        return with(dto) {
            ShopItem(
                name = name ?: DEFAULT_NAME,
                count = count ?: DEFAULT_COUNT,
                enabled = true
            )
        }
    }
    fun mapToShopItemDtoString(shopItem: ShopItem): String {
        return with(shopItem) {
            id.toString().plus(" ")
                .plus(name).plus(" ")
                .plus(count)
        }
    }

    companion object {
        private const val DEFAULT_NAME = "NAME"
        private const val DEFAULT_COUNT = 3
    }
}