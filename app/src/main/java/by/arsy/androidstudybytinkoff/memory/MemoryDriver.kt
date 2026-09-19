package by.arsy.androidstudybytinkoff.memory

import android.content.Context
import android.content.Context.MODE_APPEND
import android.util.Log
import androidx.datastore.core.IOException
import java.io.File

class MemoryDriver(val context: Context) {

    // simple way
    fun textIO(file: File, text: String) {
        try {
            file.writeText(text)
            Log.i(TAG, "[Simple Way] write file successfully")
        } catch (e: IOException) {
            Log.e(TAG, "[Simple Way] fail write file", e)
        }

        try {
            val readText = file.readText()
            Log.i(TAG, "[Simple Way] read file successfully: $readText")
        } catch (e: IOException) {
            Log.e(TAG, "[Simple Way] fail read file", e)
        }
    }

    // old way
    fun bytesIO(filePath: String, content: ByteArray) {
        context.openFileOutput(filePath, MODE_APPEND).let { stream ->
            try {
                stream.write(content)
                Log.i(TAG, "[Old Way] write file successfully")
            } catch (e: IOException) {
                Log.e(TAG, "[Old Way] fail write file", e)
            } finally {
                try {
                    stream.close()
                } catch (closeException: IOException) {
                    Log.e(TAG, "[Old Way] fail to close stream", closeException)
                }
            }
        }

        context.openFileInput(filePath).let { stream ->
            try {
                val fileSize = stream.channel.size().toInt()
                val byteArray = ByteArray(fileSize)
                stream.read(byteArray)
                Log.i(TAG, "[Old Way] read file successfully: ${String(byteArray)}")
            } catch (e: IOException) {
                Log.e(TAG, "[Old Way] fail read file", e)
            } finally {
                try {
                    stream.close()
                } catch (closeException: IOException) {
                    Log.e(TAG, "[Old Way] fail to close stream", closeException)
                }
            }
        }
    }

    // new way
    fun bytesIO(file: File, content: ByteArray) {
        try {
            file.outputStream().use { it.write(content) }
            Log.i(TAG, "[New Way] write file successfully")
        } catch (e: IOException) {
            Log.e(TAG, "[New Way] fail write file", e)
        }

        try {
            val text = file.inputStream().use {
                it.bufferedReader().use { reader -> reader.readText() }
            }
            Log.i(TAG, "[New Way] read file successfully: $text")
        } catch (e: IOException) {
            Log.e(TAG, "[New Way] fail read file", e)
        }
    }

    companion object {
        const val TAG = "MemoryDriver"
    }
}