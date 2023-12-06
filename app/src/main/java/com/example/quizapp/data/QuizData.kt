package com.example.quizapp.data

data class Questions(
    val question: String,
    val answers: List<String>,
    val correctAnswer: String
)

const val MAX_NO_OF_QUESTIONS = 10
const val SCORE_INCREASE = 10