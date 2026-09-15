package by.arsy.androidstudybytinkoff

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var textInput: EditText

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFS_NAME)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textInput = binding.textInput

        binding.button.setOnClickListener {
            lifecycleScope.launch {
                dataStore.edit { settings ->
                    settings.clear()  // clear
                }
            }
        }

        lifecycleScope.launch {
            val value = dataStore.data.first()[AMOUNT_PREFS_KEY] ?: 0 // read
            textInput.setText(value.toString())
        }
    }

    override fun onPause() {
        super.onPause()
        lifecycleScope.launch {
            val text = textInput.text.toString()
            dataStore.edit { settings ->   // write
                settings[AMOUNT_PREFS_KEY] = if (text.isBlank()) 0 else text.toInt()
            }
        }
    }

    companion object {
        const val PREFS_NAME = "prefs_name"
        val AMOUNT_PREFS_KEY = intPreferencesKey("amount_prefs_name")
    }
}