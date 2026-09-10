package by.arsy.androidstudybytinkoff

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.IOException
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

        val service = retrofit.create(ApiService::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val operations = service.getOperations("Oleg")
                if (operations.isSuccessful) {
                    Log.d(TAG, "response succeed, result: ${operations.body()?.operation}")
                } else {
                    Log.d(TAG, "response is not successful")
                }
            } catch (e: IOException) {
                Log.d(TAG, "Exception: ${e.message}", e)
            }
        }
    }

    private companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/InternetEducation/"
        const val TAG = "MainActivity"
    }
}