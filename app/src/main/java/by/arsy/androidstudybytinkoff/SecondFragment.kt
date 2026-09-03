package by.arsy.androidstudybytinkoff

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.arsy.androidstudybytinkoff.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    private var binding: FragmentSecondBinding? = null
    private val args: SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)

        binding?.content?.text = args.data
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}