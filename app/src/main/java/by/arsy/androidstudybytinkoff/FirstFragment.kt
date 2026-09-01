package by.arsy.androidstudybytinkoff

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.arsy.androidstudybytinkoff.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private var binding: FragmentFirstBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        binding?.navigateButton?.setOnClickListener { navigate() }

        parentFragmentManager.setFragmentResultListener(
            RESULT_REQUEST_KEY,
            this
        ) { key, bundle ->
            handleResult(bundle)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun navigate() {
        val data = binding?.field?.text.toString()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SecondFragment.newInstance(
                data,
                RESULT_REQUEST_KEY,
                RESULT_DATA_KEY
            ))
            .addToBackStack(null)
            .commit()
    }

    private fun handleResult(bundle: Bundle) {
        val data = bundle.getString(RESULT_DATA_KEY)
        Toast.makeText(requireContext(), data, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val RESULT_REQUEST_KEY = "result_request_key"
        private const val RESULT_DATA_KEY = "result_data_key"
    }

}