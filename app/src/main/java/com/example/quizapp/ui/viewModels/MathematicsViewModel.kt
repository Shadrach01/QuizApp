package com.example.quizapp.ui.viewModels


import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.data.MAX_NO_OF_QUESTIONS
import com.example.quizapp.data.QuestionEvent
import com.example.quizapp.localRepository.MathematicsDataSource
import com.example.quizapp.ui.QuestionListState
import com.example.quizapp.ui.QuizUiState
import com.example.quizapp.utils.QuizAppTitle
import kotlinx.coroutines.launch

class MathematicsViewModel() : ViewModel() {
    private val _currQuestion = mutableStateOf(QuizUiState())
    val currQuestion: State<QuizUiState> = _currQuestion


    private val _questionsList = mutableStateOf(QuestionListState())
    private val questionsList: State<QuestionListState> = _questionsList

    init {
        viewModelScope.launch {
            // Questions
            val questions = MathematicsDataSource.questions

            // Shuffle the questions and answers
            val shuffledQuiz =
                questions.map { question ->
                    val shuffledAnswers = question.answers.shuffled()
                    question.copy(answers = shuffledAnswers)
                }.shuffled().toMutableList()

            _questionsList.value = questionsList.value.copy(
                list = shuffledQuiz
            )

            _currQuestion.value = currQuestion.value.copy(
                questionNo = 1,
                currQuestion = _questionsList.value.list[0],

                )
        }

    }


    private val tag = " MainActivity"

    fun onEvent(event: QuestionEvent) {

        when (event) {
            is QuestionEvent.NextQuestion -> {
                if (_currQuestion.value.isEnabled) {
                    _currQuestion.value = currQuestion.value.copy(
                        isEnabled = false
                    )
                } else {
                    if (_currQuestion.value.currQuestion?.correctAnswer == _currQuestion.value.currAns) {
                        _currQuestion.value = currQuestion.value.copy(
                            questionNo = _currQuestion.value.questionNo!! + 1,
                            currQuestion = _questionsList.value.list[_currQuestion.value.questionNo!!],

                            )

                        _currQuestion.value = currQuestion.value.copy(
                            isEnabled = true,
                            currAns = "",
                            currQuestionCount = _currQuestion.value.currQuestionCount + 1
                        )

                        if (_currQuestion.value.currQuestionCount == MAX_NO_OF_QUESTIONS) {
                            event.navHostController.navigate(QuizAppTitle.GameOverScreen.name)

                            _currQuestion.value = currQuestion.value.copy(
                                questionNo = 1,
                                currQuestionCount = 0
                            )

                        }
                        Log.d("Debug", "Correct Answer: ${_currQuestion.value.currQuestion?.correctAnswer}")
                        Log.d("Debug", "Selected Answer: ${_currQuestion.value.currAns}")

                    } else {

                        event.navHostController.navigate(QuizAppTitle.GameOverScreen.name)
                        Log.i(tag, "Wrong Answer: ${_currQuestion.value.currQuestion?.correctAnswer}, Selected: ${_currQuestion.value.currAns}")
                        _currQuestion.value = currQuestion.value.copy(
                            questionNo = 1,
                            isEnabled = true,
                            currAns = ""
                        )

                    }

                }
            }

            is QuestionEvent.ChangeAnswer -> {
                _currQuestion.value = currQuestion.value.copy(
                    currAns = event.ans
                )
            }
        }
    }


}
