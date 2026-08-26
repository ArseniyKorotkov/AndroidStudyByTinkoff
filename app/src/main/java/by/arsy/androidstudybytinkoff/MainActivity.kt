package by.arsy.androidstudybytinkoff

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState?.let {
            counter = it.getInt(KEY_COUNTER)
        }

        updateText()

        binding.helloButton.setOnClickListener {
            counter++
            updateText()
        }

        binding.secondActivityButton.setOnClickListener {
            val intent = Intent(
                applicationContext,
                SecondActivity::class.java
            )
            intent.putExtra("EXTRA_STRING", "Hello second activity")
            intent.putExtra("EXTRA_INT", counter)
            intent.putExtra(
                "S_PERSON",
                SerializablePerson("SPerson", 42)
            )
            intent.putExtra(
                "P_PERSON",
                ParcelablePerson("PPerson", 42)
            )
            intent.putExtra(
                "P2_PERSON",
                ParcelizePerson("P2Person", 42)
            )
            startActivity(intent)
        }

        binding.cameraButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            startActivity(intent)
        }
    }

    private fun updateText() {
        binding.greetingText.text = "Hello $counter"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, counter)
    }

    companion object {
        const val KEY_COUNTER = "counter"
    }

    private fun useCursor() {

        val cursor: Cursor? = contentResolver.query(
            MyContentProvider.CONTENT_URI, // URI контента
            null, // Список столбцов для возврата (null означает все столбцы)
            null, // Параметры отбора (null означает без отбора)
            null, // Аргументы отбора
            null // Порядок сортировки (null означает сортировку по умолчанию)
        )

        cursor?.use {
            while (it.moveToNext()) {
                val name = it.getString(it.getColumnIndexOrThrow("example_column_name"))
                // Обработка значения столбца с названием "example_column_name"
            }
        }

        val insertValues = ContentValues().apply {
            put("example_column_name", "Hello")
            put("example_column_name2", "World")
        }

        val resultUri = contentResolver.insert(
            MyContentProvider.CONTENT_URI,
            insertValues
        )

        val updateValues = ContentValues().apply {
            put("example_column_name", "Hello World!")
        }

        val rowsUpdated  = contentResolver.update(
            MyContentProvider.CONTENT_URI,
            updateValues,
            "example_column_name2 = ?",
            arrayOf("World")
        )

        val rowsDeleted = contentResolver.delete(
            MyContentProvider.CONTENT_URI,
            "example_column_name2 = ?",
            arrayOf("World")
        )

    }
}