package by.arsy.androidstudybytinkoff.data.mapper

import by.arsy.androidstudybytinkoff.data.entity.ShopItemDbModel
import by.arsy.androidstudybytinkoff.domain.ShopItem

class ShopItemDbModelMapper {

    fun map(dbModel: ShopItemDbModel): ShopItem {
        return with(dbModel) {
            ShopItem(
                id = id,
                name = name,
                count = count,
                enabled = enabled
            )
        }
    }

    fun mapToShopItemDbModel(shopItem: ShopItem): ShopItemDbModel {
        return with(shopItem) {
            ShopItemDbModel(
                id = id,
                name = name,
                count = count,
                enabled = enabled
            )
        }
    }
}