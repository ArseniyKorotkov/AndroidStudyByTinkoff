package by.arsy.androidstudybytinkoff

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getOperations()
    }

    private fun getOperations() {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val contentType = "application/json".toMediaType()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()

        val service = retrofit.create(OperationService::class.java)

        service.getOperations("Oleg").enqueue(object : Callback<Operations> {
            override fun onResponse(
                call: Call<Operations?>,
                response: Response<Operations?>
            ) {
                if (response.isSuccessful) {
                    val operations = response.body()
                    Log.i(TAG, operations.toString())
                } else {
                    Log.e(TAG, "Exception: ${response.code()}")
                }
            }

            override fun onFailure(
                call: Call<Operations?>,
                throwable: Throwable
            ) {
                Log.e(TAG, "Exception: ${throwable.message}", throwable)
            }
        })

    }

    private companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/InternetEducation/"
        const val TAG = "MainActivity"
    }
}