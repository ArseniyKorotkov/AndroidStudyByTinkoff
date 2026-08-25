package by.arsy.androidstudybytinkoff

import android.content.Intent
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
}