package com.example.quizapp.ui.quizScreens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
fun GameOverScreen(
    onStartOverButtonClicked: () -> Unit,
    navHostController: () -> Unit,
    modifier: Modifier = Modifier
) {

    BackHandler {
        navHostController()
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(dimensionResource(R.dimen.padding_large))
            .fillMaxSize()
    ) {

        Text(
            text = stringResource(R.string.game_over),
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onTertiaryContainer,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(R.string.start_over),
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))

        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onStartOverButtonClicked,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Text(
                text = stringResource(R.string.start_over_button),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}


@Preview
@Composable
fun GameOverScreenPreview() {
    QuizAppTheme {
        GameOverScreen(
            onStartOverButtonClicked = {},
            navHostController = {},
        )
    }
}