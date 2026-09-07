package by.arsy.androidstudybytinkoff

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.arsy.androidstudybytinkoff.adapter.EventAdapter
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding
import by.arsy.androidstudybytinkoff.event.EventGenerator
import by.arsy.androidstudybytinkoff.networkExample.MyDataModel
import by.arsy.androidstudybytinkoff.networkExample.RetrofitClient

const val HAPPY_STATE = 1
const val SAD_STATE = 0

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

        binding.emoji.setOnClickListener {
            happinessState = if (happinessState == HAPPY_STATE) {
                SAD_STATE
            } else {
                HAPPY_STATE
            }
        }
    }

    private fun setGreetingText(textResId: Int) {
        val greetingText = binding.greetingText
        val text = getText(textResId)
        if (text != greetingText.text) {
            greetingText.text = text
        }
    }

    private fun callApiService() {
        RetrofitClient.apiService.getData().enqueue(object : retrofit2.Callback<List<MyDataModel>> {
            override fun onResponse(
                call: retrofit2.Call<List<MyDataModel>>,
                response: retrofit2.Response<List<MyDataModel>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                }
            }

            override fun onFailure(call: retrofit2.Call<List<MyDataModel>>, t: Throwable) {

            }
        })
    }

    //make a such way for simple example
    companion object {
        var happinessState = HAPPY_STATE
    }
}