package by.arsy.androidstudybytinkoff

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.androidImage.setOnClickListener {
            setGreetingText(R.string.hello_from_android)
        }

        binding.helloButton.setOnClickListener {
            setGreetingText(R.string.hello_world)
        }
    }

    private fun setGreetingText(textResId: Int) {
        val greetingText = binding.greetingText
        val text = getText(textResId)
        if (text != greetingText.text) {
            greetingText.text = text
        }
    }
}