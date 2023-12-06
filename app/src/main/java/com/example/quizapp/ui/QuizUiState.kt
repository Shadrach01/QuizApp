package com.example.quizapp.ui

import com.example.quizapp.data.Questions

//uiState for the Question Screen
data class QuizUiState(
    val questionNo: Int? = 1,
    val currQuestion: Questions? =
        Questions(
            question = "",
            answers = listOf(),
            correctAnswer = ""
        ),
    val isEnabled: Boolean = true,
    val currAns: String = "",
    val isGameOver: Boolean = false,
    val currQuestionCount: Int = 0,
    val wrongAnswer: Boolean = false
)


//uiState for the lis of questions
data class QuestionListState(
    val list: List<Questions> = mutableListOf(),
)



//uiState for the Dialog for the GameOverScreen
data class DialogState(
    val state: Boolean = false,
    val text: String = "",

    )


