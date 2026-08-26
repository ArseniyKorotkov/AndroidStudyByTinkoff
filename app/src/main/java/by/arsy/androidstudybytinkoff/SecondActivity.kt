package by.arsy.androidstudybytinkoff

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val extraString = intent.getStringExtra("EXTRA_STRING")
        val extraInt = intent.getIntExtra("EXTRA_INT", 0)
        val sPerson = IntentCompat.getSerializableExtra(
            intent,
            "S_PERSON",
            SerializablePerson::class.java
        )
        val pPerson = IntentCompat.getParcelableExtra(
            intent,
            "P_PERSON",
            ParcelablePerson::class.java
        )
        val p2Person = IntentCompat.getParcelableExtra(
            intent,
            "P2_PERSON",
            ParcelizePerson::class.java
        )

        val textView = findViewById<TextView>(R.id.second_activity_text)
        textView.text = "$extraString $extraInt\n${sPerson?.name}\n${pPerson?.name}\n${p2Person?.name}"
    }
}