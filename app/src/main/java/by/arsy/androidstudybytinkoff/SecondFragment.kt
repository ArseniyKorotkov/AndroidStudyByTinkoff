package by.arsy.androidstudybytinkoff

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.arsy.androidstudybytinkoff.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    var binding: FragmentSecondBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)

        binding?.content?.text = arguments?.getString(ARG_DATA)

        binding?.rejectButton?.setOnClickListener { closeWithResult("reject") }
        binding?.confirmButton?.setOnClickListener { closeWithResult("confirm") }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun closeWithResult(data: String) {
        val resultRequestKey = arguments?.getString(RESULT_REQUEST_KEY).orEmpty()
        val resultDataKey = arguments?.getString(RESULT_DATA_KEY).orEmpty()
        val result = Bundle().apply { putString(resultDataKey, data) }
        parentFragmentManager.setFragmentResult(resultRequestKey, result)
        parentFragmentManager.popBackStack()
    }

    companion object {

        private const val RESULT_REQUEST_KEY = "result_request_key"
        private const val RESULT_DATA_KEY = "result_data_key"
        private const val ARG_DATA = "arg_data"

        fun newInstance(
            data: String,
            resultRequestKey: String,
            resultDataKey: String
        ) : SecondFragment {
            return SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DATA, data)
                    putString(RESULT_REQUEST_KEY, resultRequestKey)
                    putString(RESULT_DATA_KEY, resultDataKey)
                }
            }
        }
    }
}