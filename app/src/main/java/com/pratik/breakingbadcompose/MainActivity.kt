package com.pratik.breakingbadcompose

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pratik.breakingbadcompose.ui.theme.BreakingBadComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import com.pratik.breakingbadcompose.presentation.CharacterViewModel


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    val characterViewModel: CharacterViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_sample)
        textView = findViewById(R.id.text_dashboard)

        characterViewModel.uiState.observe(
            this,
            {
                when (it) {
                    is CharacterViewModel.UIState.Success -> {

                    }
                    is CharacterViewModel.UIState.Loading -> {

                    }
                    is CharacterViewModel.UIState.Failure -> {

                    }

                }
            }
        )
//        setContent {
//
//            BreakingBadComposeTheme {
//
//                var responseText = ""
//
//                viewModel.characterDomainLiveData.observeAsState(initial = UiState.Loading).value.let { uiState ->
//                    when (uiState) {
//                        UiState.Loading -> {
//                            responseText = "Loading"
//                        }
//
//                        UiState.Success -> {
//                            responseText = it.data
//                        }
//                        UiState.Error -> {
//
//                        }
//
//
//                    }
//
//                }
//            }
//        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BreakingBadComposeTheme {
        Greeting("Android")
    }
}