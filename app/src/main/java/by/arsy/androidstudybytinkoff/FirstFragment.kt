package by.arsy.androidstudybytinkoff

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.arsy.androidstudybytinkoff.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private var binding: FragmentFirstBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        binding?.navigateButton?.setOnClickListener {
            val data = binding?.field?.text.toString()
            findNavController().navigate(FirstFragmentDirections.actiionFirstToSecond(
                data
            ))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}