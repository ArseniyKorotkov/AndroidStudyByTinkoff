package by.arsy.androidstudybytinkoff

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

class MessagesFragment : Fragment(R.layout.fragment_example) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("MESSAGE")?.let {
            val textView = view.findViewById<TextView>(R.id.fragment_demo)
            textView.text = it
        }

        val resultBundle = Bundle().apply {
            putString("RESULT_EXTRA", "Данные из фрагмента приняты!")
        }
        view.findViewById<Button>(R.id.update_fragment_button).setOnClickListener {
            setFragmentResult("REQUEST_KEY", resultBundle)
        }

    }
}