package by.arsy.androidstudybytinkoff

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    private val sharedPref: SharedPreferences by lazy {
        baseContext.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
    }
    private lateinit var sharedPrefEditor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefEditor = sharedPref.edit()

        val textInput = binding.textInput

        textInput.doOnTextChanged { _, _, _, _ ->
            val text = textInput.text.toString()
            sharedPrefEditor.putInt(  // put to editor
                AMOUNT_PREFS_KEY,
                if (text.isBlank()) 0 else text.toInt()
            )
        }

        binding.button.setOnClickListener {
            sharedPrefEditor.clear() // clear editor
        }

        val restoreAmount = sharedPref.getInt(AMOUNT_PREFS_KEY, 0) // get from app settings
        textInput.setText(restoreAmount.toString())
    }

    override fun onPause() {
        super.onPause()
        sharedPrefEditor.apply() // save from editor to app settings
    }

    companion object {
        const val PREFS_NAME = "prefs_name"
        const val AMOUNT_PREFS_KEY = "amount_prefs_name"
    }
}