package by.arsy.androidstudybytinkoff

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val awaitTime = 1000L
    private val extraAwaitTime = 10
    private val flow: Flow<Int> = flow {
        repeat(10) {
            delay(awaitTime)
            Log.i(TAG, "Main flow emit: $it")
            emit(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        flowExample(binding.greetingText)
    }

    private fun flowExample(view: TextView) {
        lifecycleScope.launch {
            flow
                .filter { it < 5 }
                .flatMapConcat {
                    flow {
                        delay(awaitTime)
                        Log.i(TAG, "Concat flow emit: $it")
                        emit(it)
                    }
                }
                .map { "Number: $it" }
                .collect { value ->
                    delay(awaitTime + extraAwaitTime)
                    view.text = value
                    Log.i(TAG, "Show value: $value")
                }
            delay(700)
            view.text = "reset"

            flow
                .map { it.toString() }
                .collectLatest { value ->
                    delay(awaitTime + extraAwaitTime)
                    view.text = value
                    Log.i(TAG, "Show value: $value")
                }
        }
    }

    private companion object {
        const val TAG = "MainActivity"
    }
}