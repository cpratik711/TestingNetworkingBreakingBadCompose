package com.pratik.breakingbadcompose.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratik.breakingbadcompose.data.response.CharacterResponse
import com.pratik.breakingbadcompose.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.pratik.breakingbadcompose.data.repository.CharacterRepository
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(val characterRepository: CharacterRepository) :
    ViewModel() {


    private val _uiState = MutableLiveData<UIState>()
    val uiState: LiveData<UIState> get() = _uiState

    sealed class UIState {
        object Loading : UIState()
        data class Success(val response: CharacterResponse) : UIState()
        data class Failure(val error: Throwable) : UIState()
    }

    init {
        _uiState.setValue(UIState.Loading)
        getAllCharacters()
    }

    private fun getAllCharacters() {
        viewModelScope.launch {
            characterRepository.getAllCharacters().collect {
                when (it) {
                    is Status.OnFailed -> {
                        val error = it.throwable
                        _uiState.setValue(UIState.Failure(error))
                    }
                    is Status.OnSuccess -> {
                        _uiState.value = UIState.Success(it.response)
                    }
                }
            }
        }
    }
}
