package by.arsy.androidstudybytinkoff

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import by.arsy.androidstudybytinkoff.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        workInCoroutine(binding.greetingText)
    }

    private fun workInCoroutine(textView: TextView) {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.i(TAG, "Handle: ${throwable.message}")
        }

        val mainCoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.i(TAG, "Main handle: ${throwable.message}")
        }

        // coroutineExceptionHandler is helpful for save app
        lifecycleScope.launch(mainCoroutineExceptionHandler/*delete it for experiment*/) {
            // scope use Dispatchers.MAIN as default dispatcher
            // here shift to Dispatchers.IO
            withContext(Dispatchers.IO) {
                try {
                    coroutineScope {
                        // coroutineExceptionHandler is helpless in coroutineScope
                        launch(coroutineExceptionHandler) {
                            delay(1000)
                            try {
                                launch {
                                    try {
                                        throw Error("Coroutine error 1")
                                    } catch (e: Error) {
                                        Log.i(TAG, "Catch: ${e.message}")
                                    }
                                    throw Error("Coroutine error 2")
                                }
                            } catch (e: Error) {
                                Log.i(TAG, "Catch: ${e.message}. Never print")
                            }
                        }

                        launch {
                            delay(8000)
                            Log.i(TAG, "Not work after another launch error. Never print")
                        }
                    }
                } catch (e: Error) {
                    Log.i(TAG, "Catch: ${e.message}")
                }
                Log.i(TAG, "Coroutine done")


                supervisorScope {
                    // coroutineExceptionHandler is helpful in supervisorScope
                    launch(coroutineExceptionHandler) {
                        delay(1000)
                        Log.i(TAG, "Throw supervisor 1 error")
                        throw Error("Supervisor 1 error")
                    }
                    val asyncResult = async {
                        delay(2000)
                        Log.i(TAG, "Work in supervisor 1 after another launch error")
                        "Supervisor 1 async result"
                    }
                    delay(1000)
                    Log.i(TAG, asyncResult.await())
                }
                Log.i(TAG, "Supervisor 1 done")

                try {
                    supervisorScope {
                        // can take coroutineExceptionHandler from parent scope (lifecycleScope)
                        // try delete coroutineExceptionHandler from lifecycleScope
                        launch {
                            delay(1000)
                            Log.i(TAG, "Throw supervisor 2 error")
                            throw Error("Supervisor 2 error")
                        }
                        launch {
                            delay(2000)
                            Log.i(TAG, "Work in supervisor 2 after another launch error")
                        }
                    }
                } catch (e: Error) {
                    Log.i(TAG, "Catch: ${e.message}. Never print")
                }
                Log.i(TAG, "Supervisor 2 done if lifecycleScope have coroutineExceptionHandler. Else app crash")
            }
            Log.i(TAG, "Continue work in Dispatcher.MAIN")
            textView.text = "Success coroutine work!"
        }
    }

    private companion object {
        const val TAG = "MainActivity"
    }
}