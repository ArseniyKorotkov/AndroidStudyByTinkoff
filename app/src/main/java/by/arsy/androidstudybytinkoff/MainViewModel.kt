package by.arsy.androidstudybytinkoff

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _state: MutableStateFlow<Int> = MutableStateFlow(0)
    val state: StateFlow<Int> = _state.asStateFlow()

    fun addCounter() {
        _state.value++
    }
}