package com.example.quizapp.ui.quizScreens

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quizapp.R
import com.example.quizapp.data.DialogEvent
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.ui.viewModels.WelcomeScreenViewModel
import com.example.quizapp.utils.WindowInfo
import com.example.quizapp.utils.rememberWindowInfo

@Composable
fun WelcomeScreen(
    onButtonClicked: () -> Unit,

    modifier: Modifier = Modifier
) {

    val viewModel: WelcomeScreenViewModel = viewModel()

    val uiState by viewModel.dialog

    val activity = (LocalContext.current as? Activity)

    val windowInfo = rememberWindowInfo()

    BackHandler {
        viewModel.onEvent(DialogEvent.OpenDialog)
    }

    if (uiState.state) {
        AlertDialog(
            onDismissRequest = { viewModel.onEvent(DialogEvent.CloseDialog) },
            confirmButton = {
                Button(
                    onClick = { activity?.finish() },
                    modifier = Modifier.padding(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorScheme.primary,
                        contentColor = colorScheme.onPrimary
                    ),
                    shape = shapes.medium
                ) {
                    Text(
                        text = stringResource(R.string.yes),
                        textAlign = TextAlign.Center
                    )
                }
            },
            text = {
                Text(text = stringResource(R.string.exit_app))
            },

            )
    }
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .background(colorScheme.inverseOnSurface)
                .padding(dimensionResource(R.dimen.padding_medium))
                .fillMaxSize()
        ) {
            Image()
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_medium)))
            Text(
                text = stringResource(R.string.welcome_text),
                style = typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(R.dimen.padding_small),
                        vertical = dimensionResource(R.dimen.padding_small)
                    )
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_medium)))
            OutlinedButton(
                onClick = onButtonClicked,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_large)),
                border = BorderStroke(2.dp, color = colorScheme.outline)
            ) {
                Text(
                    text = stringResource(R.string.start_button),
                    style = typography.headlineLarge,
                    modifier = Modifier

                )

            }
        }
    } else {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .background(colorScheme.inverseOnSurface)
                .padding(dimensionResource(R.dimen.padding_medium))
                .fillMaxSize()
        ) {
            Column {
                Image()
            }

            Spacer(modifier = Modifier.width(32.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.welcome_text),
                    style = typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(
                            horizontal = dimensionResource(R.dimen.padding_small),
                            vertical = dimensionResource(R.dimen.padding_small)
                        )
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_medium)))
                OutlinedButton(
                    onClick = onButtonClicked,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_large)),
                    border = BorderStroke(2.dp, color = colorScheme.outline)
                ) {
                    Text(
                        text = stringResource(R.string.start_button),
                        style = typography.headlineLarge,
                        modifier = Modifier

                    )

                }
            }
        }
    }
}


@Composable
private fun Image(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
    ) {
        Image(
            painter = painterResource(R.drawable.slide),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(dimensionResource(R.dimen.image_size))
        )
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    QuizAppTheme {
        WelcomeScreen(
            onButtonClicked = { /*TODO*/ },
        )
    }
}


@Preview(device = Devices.TABLET, showSystemUi = true)
@Composable
private fun WelcomeScreenCompact() {
QuizAppTheme {
    WelcomeScreen(onButtonClicked = { /*TODO*/ })
}
}