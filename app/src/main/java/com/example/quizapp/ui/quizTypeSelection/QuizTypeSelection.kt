package com.example.quizapp.ui.quizTypeSelection

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizapp.R
import com.example.quizapp.ui.theme.QuizAppTheme


@Composable
fun QuizTypeSelection(
    modifier: Modifier = Modifier,
    unScrambleClicked: () -> Unit,
    quizQuestions: () -> Unit,
    navHostController: () -> Unit
) {

    BackHandler {
        navHostController()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorScheme.surface),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.please_select),
            style = typography.displayMedium
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))

        TextButton(onClick = unScrambleClicked) {
            Text(
                text = stringResource(R.string.unScramble),
                style = typography.displayMedium,
                textAlign = TextAlign.Center,
                color = colorScheme.onBackground,
                modifier = Modifier
                    .border(2.5.dp, colorScheme.tertiary, MaterialTheme.shapes.small)
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.padding_medium),
                        vertical = dimensionResource(id = R.dimen.padding_small)
                    )
            )
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))

        TextButton(onClick = quizQuestions) {
            Text(
                text = stringResource(R.string.quiz_questions),
                style = typography.displayMedium,
                textAlign = TextAlign.Center,
                color = colorScheme.onBackground,
                modifier = Modifier
                    .border(
                        2.5.dp,
                        colorScheme.tertiary,
                        MaterialTheme.shapes.small
                    )

                    .padding(
                        horizontal = dimensionResource(id = R.dimen.padding_medium),
                        vertical = dimensionResource(id = R.dimen.padding_small)
                    )


            )
        }
    }
}


@Preview
@Composable
fun QuizTypePreview() {
    QuizAppTheme {
        QuizTypeSelection(unScrambleClicked = { /*TODO*/ },
            quizQuestions = {},
            navHostController = {}
            )
    }
}