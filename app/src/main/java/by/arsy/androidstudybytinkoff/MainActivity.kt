package by.arsy.androidstudybytinkoff

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var counter = 0
        binding.helloButton.setOnClickListener {
            counter++
            binding.greetingText.text = "Hello $counter"
        }
    }
}