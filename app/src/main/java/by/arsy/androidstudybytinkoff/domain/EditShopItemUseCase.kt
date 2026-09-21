package by.arsy.androidstudybytinkoff.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    operator fun invoke(shopItem: ShopItem) {
        return shopListRepository.editShopItem(shopItem)
    }

}