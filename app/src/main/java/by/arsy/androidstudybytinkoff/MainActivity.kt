package by.arsy.androidstudybytinkoff

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding
import by.arsy.androidstudybytinkoff.memory.MemoryDriver
import kotlinx.coroutines.launch
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var textInput: EditText

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFS_NAME)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        memory()
    }

    private fun memory() {


        // external memory files


        // cache memory files
        val createTempFile = File.createTempFile(
            FILE_NAME,
            null,
            applicationContext.cacheDir
        )
        val cacheFile = File(applicationContext.cacheDir, FILE_NAME)
        Log.i(TAG, "are same ${createTempFile == cacheFile}")
        applicationContext.deleteFile(FILE_NAME)
        createTempFile.delete()


        val memoryDriver = MemoryDriver(applicationContext)
        innerMemory(memoryDriver)
        externalMemory(memoryDriver)
        cacheMemory(memoryDriver)

    }

    private fun innerMemory(memoryDriver: MemoryDriver) {
        val dir = applicationContext.getDir(DIR_NAME, MODE_PRIVATE)
        val rootFile = File(applicationContext.filesDir, FILE_NAME)
        val dirFile = File(dir, FILE_NAME)

        memoryDriver.textIO(
            file = rootFile,
            text = "Simple inner write text\n"
        )

        memoryDriver.bytesIO(
            filePath = FILE_NAME,
            content = "Hello from inner root".toByteArray()
        )

        memoryDriver.bytesIO(
            file = dirFile,
            content = "Hello from inner dir".toByteArray()
        )

        val fileList = applicationContext.fileList()
        Log.i(TAG, fileList.contentToString())
    }

    private fun externalMemory(memoryDriver: MemoryDriver) {
        checkExternalMemoryAbility()
        val externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOCUMENTS
        )
        val externalFile = File(externalStoragePublicDirectory, FILE_NAME)

        memoryDriver.textIO(
            file = externalFile,
            text = "Simple external write text\n"
        )
    }

    private fun checkExternalMemoryAbility(): Boolean {
        val checkSelfPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (checkSelfPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                1
            )
        }
        return isExternalStorageWritable()
    }
    private fun isExternalStorageWritable(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }

    private fun isExternalStorageReadable(): Boolean {
        return Environment.getExternalStorageState() in setOf(
            Environment.MEDIA_MOUNTED,
            Environment.MEDIA_MOUNTED_READ_ONLY
        )
    }

    private fun cacheMemory(memoryDriver: MemoryDriver) {
        val createTempFile = File.createTempFile( // create empty file in cache memory with random name
            FILE_NAME,
            null,
            applicationContext.cacheDir
        )

        val cacheFile = File(
            applicationContext.cacheDir,
            FILE_NAME
        ) // create file kotlin object without file in memory
        memoryDriver.bytesIO(
            file =  cacheFile,
            content = "Hello from cache".toByteArray()
        )
        Log.i(TAG, "are same ${createTempFile == cacheFile}")

        applicationContext.deleteFile(FILE_NAME) // delete by file name
        createTempFile.delete() // delete by file object
    }

    companion object {

        const val TAG = "MainActivity"
        const val PREFS_NAME = "prefs_name"
        const val FILE_NAME = "file_name"
        const val DIR_NAME = "dir_name"
    }
}