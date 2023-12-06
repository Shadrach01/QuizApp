package com.example.quizapp.data

import androidx.navigation.NavHostController

sealed class QuestionEvent {
    data class NextQuestion(val navHostController: NavHostController) : QuestionEvent()
    data class ChangeAnswer(val ans: String) : QuestionEvent()

}


sealed class DialogEvent {
    object OpenDialog : DialogEvent()
    object CloseDialog : DialogEvent()
}


