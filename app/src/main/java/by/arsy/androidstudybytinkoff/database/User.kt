package by.arsy.androidstudybytinkoff.database

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    ignoredColumns = ["resume"] // not create this column in DB
)
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0, // create id automatically
    @ColumnInfo(name = "first_name") override val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
): BaseUser() {
    @Ignore val picture: Bitmap? = null // not create this column in DB
}

open class BaseUser() {
    open val firstName: String? = null
    val resume: String? = null
}