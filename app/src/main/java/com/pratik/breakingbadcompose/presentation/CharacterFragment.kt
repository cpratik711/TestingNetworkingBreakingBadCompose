package com.pratik.breakingbadcompose.presentation

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pratik.breakingbadcompose.R
import javax.inject.Inject

class CharacterFragment : Fragment() {

    @Inject
    lateinit var characterViewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sample, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        textView.movementMethod = ScrollingMovementMethod()

        characterViewModel.uiState.observe(viewLifecycleOwner, { uiState ->
            uiState?.let {
                when (it) {
                    is CharacterViewModel.UIState.Loading -> {
                        textView.text = "Loading"
                    }
                    is CharacterViewModel.UIState.Success -> {
                        textView.text = it.response.toString()
                    }
                    is CharacterViewModel.UIState.Failure -> {
                        textView.text = it.error.message
                    }
                }
            }
        })
        return root
    }

}
