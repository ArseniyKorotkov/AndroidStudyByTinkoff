package by.arsy.androidstudybytinkoff

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val extraString = intent.getStringExtra("EXTRA_STRING")
        val extraInt = intent.getIntExtra("EXTRA_INT", 0)

        val textView = findViewById<TextView>(R.id.second_activity_text)
        textView.text = "$extraString $extraInt"
    }
}