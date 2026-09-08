package by.arsy.androidstudybytinkoff

import kotlinx.serialization.Serializable

@Serializable
data class Operation(
    val name: String,
    val amount: Int
)

@Serializable
data class Operations(
    val operation: List<Operation>
)
