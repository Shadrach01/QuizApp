package com.example.quizapp.utils

import androidx.annotation.StringRes
import com.example.quizapp.R

enum class QuizAppTitle(@StringRes val title: Int) {
    WelcomeScreen(title = R.string.app_title_name),
    SelectType(title = R.string.select_type),
    SubjectSelection(title = R.string.subject_selection),
    UnScramble(title = R.string.unScramble_questions),
    ArtAndCraft(title = R.string.art_and_craft),
    English(title = R.string.english_language),
    GeneralKnowledge(title = R.string.general_knowledge),
    Geography(title = R.string.geography),
    Mathematics(title = R.string.mathematics),
    ReligiousStudy(title = R.string.religious_study),
    GameOverScreen(title = R.string.you_loose_title)
}