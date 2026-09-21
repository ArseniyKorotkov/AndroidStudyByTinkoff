package by.arsy.androidstudybytinkoff.data.datasource.local

import by.arsy.androidstudybytinkoff.data.entity.ShopItemDbModel

class LocalDataSourceImpl(private val dao: ShopItemDao) : LocalDataSource {

    override fun getShopList(): List<ShopItemDbModel> {
        return dao.getShopList()
    }

    override suspend fun getShopItem(shopItemId: Int): ShopItemDbModel? {
        return dao.getShopItem(shopItemId)
    }

    override suspend fun addShopItem(shopItemDbModel: ShopItemDbModel) {
        dao.addShopItem(shopItemDbModel)
    }

    override suspend fun deleteShopItem(shopItemDbModel: ShopItemDbModel) {
        dao.deleteShopItem(shopItemDbModel.id)
    }
}