package com.example.quizapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.quizapp.ui.QuizUiState
import com.example.quizapp.ui.quizScreens.ArtAndCraftScreen
import com.example.quizapp.ui.quizScreens.EnglishScreen
import com.example.quizapp.ui.quizScreens.GameOverScreen
import com.example.quizapp.ui.quizScreens.GeneralKnowledgeScreen
import com.example.quizapp.ui.quizScreens.GeographyScreen
import com.example.quizapp.ui.quizScreens.MathematicsScreen
import com.example.quizapp.ui.quizScreens.ReligiousStudyScreen
import com.example.quizapp.ui.quizScreens.SubjectSelection
import com.example.quizapp.ui.quizScreens.WelcomeScreen
import com.example.quizapp.ui.quizTypeSelection.QuizTypeSelection
import com.example.quizapp.ui.unScramble.UnScrambleScreen


@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {

    NavHost(
        navController = navHostController,
        startDestination = QuizAppTitle.WelcomeScreen.name,
        modifier = modifier
    ) {
        composable(
            route = QuizAppTitle.WelcomeScreen.name
        ) {
            WelcomeScreen(
                onButtonClicked = {
                    navHostController.navigate(QuizAppTitle.SelectType.name)
                },
            )
        }

        navigation(
            startDestination = QuizAppTitle.SelectType.name,
            route = "quiz_app"
        ) {

            composable(
                QuizAppTitle.SelectType.name
            ) {
                QuizTypeSelection(
                    unScrambleClicked = {
                        navHostController.navigate(QuizAppTitle.UnScramble.name)
                    },
                    quizQuestions = {
                        navHostController.navigate(QuizAppTitle.SubjectSelection.name)
                    },
                    navHostController = {
                        navHostController.navigate(QuizAppTitle.WelcomeScreen.name) {
                            popUpTo("quiz_app") {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable(QuizAppTitle.UnScramble.name) {
                UnScrambleScreen(
                    navHostController = {
                        navHostController.navigate(QuizAppTitle.SelectType.name) {
                            popUpTo("quiz_app") {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable(route = QuizAppTitle.ArtAndCraft.name) {
                ArtAndCraftScreen(navHostController = navHostController)
            }

            composable(route = QuizAppTitle.English.name) {
                EnglishScreen(navHostController = navHostController)
            }

            composable(route = QuizAppTitle.GeneralKnowledge.name) {
                GeneralKnowledgeScreen(navHostController = navHostController)
            }

            composable(route = QuizAppTitle.Geography.name) {
                GeographyScreen(navHostController = navHostController)
            }

            composable(route = QuizAppTitle.Mathematics.name) {
                MathematicsScreen(navHostController = navHostController)
            }

            composable(route = QuizAppTitle.ReligiousStudy.name) {
                ReligiousStudyScreen(navHostController = navHostController)
            }


        }

        navigation(
            startDestination = QuizAppTitle.SubjectSelection.name,
            route = "subject_selection"
        ) {
            composable(
                route = QuizAppTitle.SubjectSelection.name
            ) {
                SubjectSelection(
                    onEnglishClick = {
                        navHostController.navigate(QuizAppTitle.English.name)
                    },
                    onMathematicsClick = {
                        navHostController.navigate(QuizAppTitle.Mathematics.name)
                    },
                    onGeographyClick = {
                        navHostController.navigate(QuizAppTitle.Geography.name)
                    },
                    onArtAndCraftClick = {
                        navHostController.navigate(QuizAppTitle.ArtAndCraft.name)
                    },
                    onReligiousStudyClick = {
                        navHostController.navigate(QuizAppTitle.ReligiousStudy.name)
                    },
                    onGeneralKnowledgeClick = {
                        navHostController.navigate(QuizAppTitle.GeneralKnowledge.name)

                    },
                    navHostController = {
                        navHostController.navigate("quiz_app") {
                            popUpTo("subject_selection") {
                                inclusive = true
                            }
                        }
                    }

                )
            }
        }

        navigation(
            startDestination = QuizAppTitle.GameOverScreen.name,
            route = "game_over"
        ) {
            composable(route = QuizAppTitle.GameOverScreen.name) {
                GameOverScreen(
                    onStartOverButtonClicked = {
                        navHostController.navigate(QuizAppTitle.SubjectSelection.name) {
                            popUpTo("game_over") {
                                inclusive = true
                            }
                        }
                    },
                    navHostController = {
                        navHostController.navigate(QuizAppTitle.SubjectSelection.name) {
                            popUpTo("game_over") {
                                inclusive = true
                            }
                        }
                    },
                )

            }
        }


    }
}

