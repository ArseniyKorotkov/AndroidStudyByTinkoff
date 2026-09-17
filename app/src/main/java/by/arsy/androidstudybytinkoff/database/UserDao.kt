package by.arsy.androidstudybytinkoff.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg users: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE first_name LIKE :searchName")
    fun getSome(searchName: String): List<User>

    @Query("SELECT * FROM users WHERE first_name IN (:searchName)")
    fun getSome(searchName: List<String>): List<User>
}