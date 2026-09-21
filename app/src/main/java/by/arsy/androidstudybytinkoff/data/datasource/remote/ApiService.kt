package by.arsy.androidstudybytinkoff.data.datasource.remote

import by.arsy.androidstudybytinkoff.data.entity.ShopItemDTO
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("/v1/shopitems")
    suspend fun getShopList(): List<ShopItemDTO>

    @GET("/v1/shopitems/{shopItemId}")
    suspend fun getShopItem(
       @Path("shopItemId") shopItemId: String
    ): ShopItemDTO?

    @POST("/v1/shopitems/{shopItemId}")
    suspend fun addShopItem(
        @Path("shopItemId") shopItemId: String,
        @Field("content") content: String
    )

    @PATCH("/v1/edit_shopitems/{shopItemId}")
    suspend fun editShopItem(
        @Path("shopItemId") shopItemId: String,
        @Field("content") content: String
    )

    @DELETE("/v1/shopitems/{shopItemId}")
    suspend fun deleteShopItem(
        @Path("shopItemId") shopItemId: String,
        @Field("content") content: String
    )
}