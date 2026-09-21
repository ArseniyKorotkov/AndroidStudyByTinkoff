package by.arsy.androidstudybytinkoff.domain

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    operator fun invoke(shopItem: ShopItem) {
        return shopListRepository.deleteShopItem(shopItem)
    }

}