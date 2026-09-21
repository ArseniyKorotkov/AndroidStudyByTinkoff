package by.arsy.androidstudybytinkoff.data.datasource.local

import by.arsy.androidstudybytinkoff.data.entity.ShopItemDbModel


interface LocalDataSource {

    fun getShopList(): List<ShopItemDbModel>

    suspend fun getShopItem(shopItemId: Int): ShopItemDbModel?

    suspend fun addShopItem(shopItemDbModel: ShopItemDbModel)

    suspend fun deleteShopItem(shopItemDbModel: ShopItemDbModel)

}