package by.arsy.androidstudybytinkoff.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.arsy.androidstudybytinkoff.Analytics
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var analytics: Analytics
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        analytics.onShown()
    }

    companion object {
        const val TAG = "MainActivity"
    }
}