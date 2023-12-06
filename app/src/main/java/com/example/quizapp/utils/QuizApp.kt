package com.example.quizapp.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun QuizApp() {

    //Create NavController
    val navController = rememberNavController()

    //Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = QuizAppTitle.valueOf(
        backStackEntry?.destination?.route ?: QuizAppTitle.SubjectSelection.name
    )

    Scaffold(

        topBar = {
            if (currentScreen != QuizAppTitle.GameOverScreen
                && currentScreen != QuizAppTitle.WelcomeScreen) {
                QuizAppBar(currentTitle = currentScreen.title,
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = {
                        if (currentScreen == QuizAppTitle.SubjectSelection) {
                            navController.navigate(QuizAppTitle.SelectType.name)
                        } else if (currentScreen == QuizAppTitle.SelectType) {
                            navController.navigate(QuizAppTitle.WelcomeScreen.name)
                        }
                        else {
                            navController.navigateUp()
                        }


                    }
                )
            }
        }
    ) { innerPadding ->
        NavigationGraph(
            navHostController = navController,
            modifier = Modifier.padding(innerPadding)

        )

    }
}



