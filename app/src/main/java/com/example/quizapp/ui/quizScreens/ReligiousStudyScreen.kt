package com.example.quizapp.ui.quizScreens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.quizapp.data.QuestionEvent
import com.example.quizapp.data.Questions
import com.example.quizapp.ui.viewModels.ReligiousKnowledgeViewModel

@Composable
fun ReligiousStudyScreen(
    navHostController: NavHostController
) {

    val viewModel: ReligiousKnowledgeViewModel = viewModel()

    val uiState by viewModel.currQuestion

    BaseQuestionsScreen(
        questionNo = uiState.questionNo!!,
        question = Questions(
            question = uiState.currQuestion?.question!!,
            answers = uiState.currQuestion?.answers!!,
            correctAnswer = uiState.currQuestion?.correctAnswer!!
        ),
        isEnabled = uiState.isEnabled,
        currAns = uiState.currAns,
        onClick = { viewModel.onEvent(QuestionEvent.ChangeAnswer(it)) },
        buttonClicked = { viewModel.onEvent(QuestionEvent.NextQuestion(navHostController)) },
        quizUiState = uiState
    )
}