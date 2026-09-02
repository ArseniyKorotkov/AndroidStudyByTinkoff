package by.arsy.androidstudybytinkoff

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.arsy.androidstudybytinkoff.databinding.FragmentExampleBinding

class ExampleFragment : Fragment(R.layout.fragment_example) {

    private var messageHolder: MessageHolder? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentExampleBinding.bind(view)
        binding.updateFragmentButton.setOnClickListener {
            messageHolder?.showMessage()
        }
    }

    fun showMessage() {
        Toast.makeText(
            context,
            "Hello from fragment",
            Toast.LENGTH_SHORT
        ).show()
    }

    companion object {
        const val TAG = "ExampleFragment"
    }

    private fun callActivityMethod() {
        messageHolder?.showMessage()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        messageHolder = context as? MessageHolder // find by interface
    }

    override fun onDetach() {
        super.onDetach()
        messageHolder = null
    }
}