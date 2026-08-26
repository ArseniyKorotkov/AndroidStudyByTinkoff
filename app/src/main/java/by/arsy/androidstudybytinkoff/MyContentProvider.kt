package by.arsy.androidstudybytinkoff

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

class MyContentProvider : ContentProvider() {
    override fun delete(
        p0: Uri,
        p1: String?,
        p2: Array<out String?>?
    ): Int {
        TODO("Not yet implemented")
    }

    override fun getType(p0: Uri): String? {
        return "vnd.android.cursor.dir/vnd.$AUTHORITY.$BASE_PATH"
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String?>?,
        p2: String?,
        p3: Array<out String?>?,
        p4: String?
    ): Cursor? {
        TODO("Not yet implemented")
    }

    override fun update(
        p0: Uri,
        p1: ContentValues?,
        p2: String?,
        p3: Array<out String?>?
    ): Int {
        TODO("Not yet implemented")
    }

    companion object {
        const val AUTHORITY = "com.exampleorders"
        const val BASE_PATH = "42"
        val CONTENT_URI: Uri = Uri.parse("contentprovider://$AUTHORITY/$BASE_PATH")
    }

}