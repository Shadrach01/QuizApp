package com.example.quizapp.ui.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quizapp.data.DialogEvent
import com.example.quizapp.ui.DialogState

class WelcomeScreenViewModel : ViewModel() {
    private val _dialogState = mutableStateOf(DialogState())
    val dialog: State<DialogState> = _dialogState

    fun onEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OpenDialog -> {
                _dialogState.value = dialog.value.copy(
                    state = true
                )
            }
            is DialogEvent.CloseDialog -> {
                _dialogState.value = dialog.value.copy(
                    state = false
                )
            }
        }
    }

}