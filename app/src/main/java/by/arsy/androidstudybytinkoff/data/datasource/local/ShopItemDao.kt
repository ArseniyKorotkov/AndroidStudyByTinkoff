package by.arsy.androidstudybytinkoff.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import by.arsy.androidstudybytinkoff.data.entity.ShopItemDbModel

@Dao
interface ShopItemDao {

    @Query("SELECT * FROM shop_items")
    fun getShopList(): List<ShopItemDbModel>

    @Query("SELECT * FROM shop_items WHERE id = :shopItemId LIMIT 1")
    suspend fun getShopItem(shopItemId: Int): ShopItemDbModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShopItem(shopItemDbModel: ShopItemDbModel)

    @Query("DELETE FROM shop_items WHERE id = :id")
    suspend fun deleteShopItem(id: Int)
}