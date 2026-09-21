package by.arsy.androidstudybytinkoff.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    operator fun invoke(shopItem: ShopItem) {
        return shopListRepository.addShopItem(shopItem)
    }

}