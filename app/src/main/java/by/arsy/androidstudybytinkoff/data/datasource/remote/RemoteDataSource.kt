package by.arsy.androidstudybytinkoff.data.datasource.remote

import by.arsy.androidstudybytinkoff.data.entity.ShopItemDTO


interface RemoteDataSource {

    suspend fun getShopList(): List<ShopItemDTO>

    suspend fun getShopItem(shopItemId: Int): ShopItemDTO?

    suspend fun addShopItem(shopItemId: String, content: String)

    suspend fun editShopItem(shopItemId: String, content: String)

    suspend fun deleteShopItem(shopItemId: String, content: String)

}