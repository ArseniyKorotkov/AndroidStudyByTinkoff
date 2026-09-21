package by.arsy.androidstudybytinkoff.data.datasource.remote

import by.arsy.androidstudybytinkoff.data.entity.ShopItemDTO

class RemoteDataSourceImpl(private val api: ApiService) : RemoteDataSource {

    override suspend fun getShopList(): List<ShopItemDTO> {
        return api.getShopList()
    }

    override suspend fun getShopItem(shopItemId: Int): ShopItemDTO? {
        return api.getShopItem(shopItemId.toString())
    }

    override suspend fun addShopItem(shopItemId: String, content: String) {
        return api.addShopItem(shopItemId, content)
    }

    override suspend fun editShopItem(shopItemId: String, content: String) {
        return api.editShopItem(shopItemId, content)
    }

    override suspend fun deleteShopItem(shopItemId: String, content: String) {
        return api.deleteShopItem(shopItemId, content)
    }
}