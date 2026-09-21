package by.arsy.androidstudybytinkoff.domain

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    operator fun invoke(): List<ShopItem> {
        return shopListRepository.getShopList()
    }

}