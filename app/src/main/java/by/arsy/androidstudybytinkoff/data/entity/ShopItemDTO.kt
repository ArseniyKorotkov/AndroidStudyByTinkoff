package by.arsy.androidstudybytinkoff.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ShopItemDTO(

    @SerialName("Id")
    val id: Int? = null,

    @SerialName("Name")
    val name: String? = null,

    @SerialName("Count")
    val count: Int? = null
)