package by.arsy.androidstudybytinkoff.domain

interface ShopListRepository {

    suspend fun getShopList(): List<ShopItem>

    suspend fun getShopItem(shopItemId: Int): ShopItem?

    suspend fun addShopItem(shopItem: ShopItem)

    suspend fun editShopItem(shopItem: ShopItem)

    suspend fun deleteShopItem(shopItem: ShopItem)

}