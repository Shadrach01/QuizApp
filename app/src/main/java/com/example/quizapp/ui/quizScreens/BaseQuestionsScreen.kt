package com.example.quizapp.ui.quizScreens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizapp.R
import com.example.quizapp.data.Questions
import com.example.quizapp.localRepository.EnglishDataSource
import com.example.quizapp.ui.QuizUiState
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.utils.WindowInfo
import com.example.quizapp.utils.rememberWindowInfo


@Composable
fun BaseQuestionsScreen(
    modifier: Modifier = Modifier,
    questionNo: Int,
    question: Questions,
    isEnabled: Boolean,
    currAns: String,
    onClick: (String) -> Unit,
    buttonClicked: () -> Unit,
    quizUiState: QuizUiState,

    ) {


    val windowInfo = rememberWindowInfo()

    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .background(colorScheme.surface)
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Box {
                    Image(
                        painter = painterResource(R.drawable.pencil_thinking),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(dimensionResource(R.dimen.pencil_image_size))
                    )
                }
                Column {
                    Text(
                        text = stringResource(
                            R.string.question_count, questionNo
                        ),
                        style = typography.displayMedium,
                        modifier = Modifier
                            .clip(shapes.medium)
                            .background(colorScheme.surfaceTint)
                            .padding(
                                horizontal = 14.dp, vertical = 8.dp
                            )
                    )
                }
            }
            QuestionCard(
                question = Questions(
                    question = question.question,
                    answers = question.answers,
                    correctAnswer = question.correctAnswer
                ),
                isEnabled = isEnabled,
                currAns = currAns,
                onClick = { onClick(it) },
                buttonClicked = buttonClicked,
                quizUiState = quizUiState
            )
        }
    } else {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .background(colorScheme.surface)
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_large))
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Box {
                        Image(
                            painter = painterResource(R.drawable.pencil_thinking),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(dimensionResource(R.dimen.pencil_image_size))
                        )
                    }
                    Column {
                        Text(
                            text = stringResource(
                                R.string.question_count, questionNo
                            ),
                            style = typography.displayMedium,
                            modifier = Modifier
                                .clip(shapes.medium)
                                .background(colorScheme.surfaceTint)
                                .padding(
                                    horizontal = 14.dp, vertical = 8.dp
                                )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(88.dp))

            Column(
                modifier = Modifier
                    .padding(end = 50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                QuestionCard(
                    question = Questions(
                        question = question.question,
                        answers = question.answers,
                        correctAnswer = question.correctAnswer
                    ),
                    isEnabled = isEnabled,
                    currAns = currAns,
                    onClick = { onClick(it) },
                    buttonClicked = buttonClicked,
                    quizUiState = quizUiState
                )


            }
        }
    }
}


@Composable
private fun QuestionCard(
    modifier: Modifier = Modifier,
    question: Questions,
    isEnabled: Boolean,
    currAns: String,
    onClick: (String) -> Unit,
    quizUiState: QuizUiState,
    buttonClicked: () -> Unit,
) {

    val context = LocalContext.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = question.question,
                style = typography.displayMedium
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                (question.answers).forEach {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .border(
                                BorderStroke(
                                    if (!isEnabled && (it == question.correctAnswer)) {
                                        3.dp
                                    } else {
                                        0.dp
                                    }, Color(0xFF058011)
                                ), RoundedCornerShape(16.dp)
                            )
                            .background(
                                if (!isEnabled && (it == question.correctAnswer)) {
                                    Color(0xFF1AC536)
                                } else {
                                    colorScheme.primary

                                }
                            )
                            .clickable(enabled = isEnabled) {
                                onClick(it)
                            }
                            .padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp, 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = currAns == it,
                                onClick = null,
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = if (!isEnabled) {
                                        Color.Black
                                    } else {
                                        Color.Cyan
                                    },
                                    unselectedColor = colorScheme.onPrimary
                                )
                            )
                            Text(
                                text = it,
                                style = typography.headlineMedium,
                                color = colorScheme.onPrimary
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))

            Button(
                modifier = Modifier.width(150.dp),
                onClick = {
                    if (quizUiState.currAns != "") {
                        buttonClicked()
                    } else {
                        Toast.makeText(
                            context,
                            context.getString(R.string.please_select_an_answer),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.tertiary,
                    contentColor = colorScheme.onTertiary
                )
            ) {
                Text(
                    text = if (quizUiState.isEnabled) {
                        stringResource(id = R.string.submit)
                    } else {
                        stringResource(id = R.string.next_button)
                    }
                )
            }
        }
    }
}


@Preview
@Composable
fun QuestionsPreview() {
    QuizAppTheme {
        BaseQuestionsScreen(
            questionNo = 2,
            question = EnglishDataSource.questions.first(),
            isEnabled = true,
            currAns = EnglishDataSource.questions.first().correctAnswer,
            onClick = {},
            buttonClicked = { /*TODO*/ },
            quizUiState = QuizUiState(),
        )

    }
}

@Preview(device = Devices.TABLET, showSystemUi = true)
@Composable
fun QuestionsPreviewTab() {
    QuizAppTheme {
        BaseQuestionsScreen(
            questionNo = 2,
            question = EnglishDataSource.questions.first(),
            isEnabled = true,
            currAns = EnglishDataSource.questions.first().correctAnswer,
            onClick = {},
            buttonClicked = { /*TODO*/ },
            quizUiState = QuizUiState(),
        )

    }
}
