package by.arsy.androidstudybytinkoff

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.arsy.androidstudybytinkoff.databinding.ActivityExampleBinding

class ExampleActivity : AppCompatActivity(), MessageHolder /* mark with interface*/ {
    private lateinit var binding: ActivityExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.example_fragment_container,
                    ExampleFragment(),
                    ExampleFragment.TAG // mark with tag
                ).commit()
        }

        binding.callFragment.setOnClickListener {
            onCallFragmentMessage()
        }
    }

    override fun showMessage() {
        Toast.makeText(
            applicationContext,
            "Hello from activity",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun onCallFragmentMessage() {
        val fragment = supportFragmentManager.findFragmentByTag(ExampleFragment.TAG) // find by tag
        (fragment as? ExampleFragment)?.showMessage()
    }
}