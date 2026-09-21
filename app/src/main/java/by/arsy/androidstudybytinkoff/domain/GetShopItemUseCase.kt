package by.arsy.androidstudybytinkoff.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    operator fun invoke(shopItemId: Int): ShopItem? {
        return shopListRepository.getShopItem(shopItemId)
    }

}