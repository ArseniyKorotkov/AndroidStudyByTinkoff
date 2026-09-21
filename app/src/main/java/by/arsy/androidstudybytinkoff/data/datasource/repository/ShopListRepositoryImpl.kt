package by.arsy.androidstudybytinkoff.data.datasource.repository

import by.arsy.androidstudybytinkoff.data.datasource.local.LocalDataSource
import by.arsy.androidstudybytinkoff.data.datasource.remote.RemoteDataSource
import by.arsy.androidstudybytinkoff.data.mapper.ShopItemDbModelMapper
import by.arsy.androidstudybytinkoff.data.mapper.ShopItemDtoMapper
import by.arsy.androidstudybytinkoff.domain.ShopItem
import by.arsy.androidstudybytinkoff.domain.ShopListRepository

class ShopListRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val shopItemDbModelMapper: ShopItemDbModelMapper,
    private val shopItemDtoMapper: ShopItemDtoMapper
) : ShopListRepository {

    override suspend fun getShopList(): List<ShopItem> {
        val local = localDataSource.getShopList()
        return if (local.isEmpty()) {
            remoteDataSource.getShopList().map { shopItemDtoMapper.map(it) }
        } else local.map { shopItemDbModelMapper.map(it) }
    }

    override suspend fun getShopItem(shopItemId: Int): ShopItem? {
        val local = localDataSource.getShopItem(shopItemId)
        return local?.let { shopItemDbModelMapper.map(it) }
            ?: remoteDataSource.getShopItem(shopItemId)?.let {  shopItemDtoMapper.map(it) }
    }

    override suspend fun addShopItem(shopItem: ShopItem) {
        localDataSource.addShopItem(shopItemDbModelMapper.mapToShopItemDbModel(shopItem))
        remoteDataSource.addShopItem(
            shopItemId = shopItem.id.toString(),
            content = shopItemDtoMapper.mapToShopItemDtoString(shopItem),
        )
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        localDataSource.addShopItem(shopItemDbModelMapper.mapToShopItemDbModel(shopItem))
        remoteDataSource.editShopItem(
            shopItemId = shopItem.id.toString(),
            content = shopItemDtoMapper.mapToShopItemDtoString(shopItem),
        )
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        localDataSource.deleteShopItem(shopItemDbModelMapper.mapToShopItemDbModel(shopItem))
        remoteDataSource.deleteShopItem(
            shopItemId = shopItem.id.toString(),
            content = shopItemDtoMapper.mapToShopItemDtoString(shopItem)
        )
    }
}