package by.arsy.androidstudybytinkoff

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.arsy.androidstudybytinkoff.adapter.EventAdapter
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding
import by.arsy.androidstudybytinkoff.event.EventGenerator

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

        val eventRecycler = binding.eventRecycler
        val eventAdapter = EventAdapter()

        eventRecycler.layoutManager = LinearLayoutManager(this)
        eventRecycler.adapter = eventAdapter

        eventAdapter.data = EventGenerator().getGeneratedEvents(50)
    }

    private fun setGreetingText(textResId: Int) {
        val greetingText = binding.greetingText
        val text = getText(textResId)
        if (text != greetingText.text) {
            greetingText.text = text
        }
    }
}