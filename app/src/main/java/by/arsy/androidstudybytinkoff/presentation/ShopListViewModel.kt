package by.arsy.androidstudybytinkoff.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.arsy.androidstudybytinkoff.domain.GetShopItemUseCase
import by.arsy.androidstudybytinkoff.domain.GetShopListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShopListViewModel(
    private val getShopList: GetShopListUseCase,
    private val mapper: ShopListItemMapper,
) : ViewModel() {

    private val _shopItems = MutableStateFlow<List<ShopListItem>>(emptyList())
    val shopItems: StateFlow<List<ShopListItem>> = _shopItems

    init {
        loadShopItems()
    }

    private fun loadShopItems() {
        viewModelScope.launch {
            _shopItems.value = getShopList().map { mapper.map(it) }
        }
    }
}