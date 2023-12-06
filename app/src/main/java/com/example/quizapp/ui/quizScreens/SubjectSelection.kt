package com.example.quizapp.ui.quizScreens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quizapp.R
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.utils.WindowInfo
import com.example.quizapp.utils.rememberWindowInfo


@Composable
fun SubjectSelection(
    onEnglishClick: () -> Unit,
    onMathematicsClick: () -> Unit,
    onGeographyClick: () -> Unit,
    onArtAndCraftClick: () -> Unit,
    onReligiousStudyClick: () -> Unit,
    onGeneralKnowledgeClick: () -> Unit,
    navHostController: () -> Unit,
    modifier: Modifier = Modifier,
) {

    val windowInfo = rememberWindowInfo()

    BackHandler {
        navHostController()
    }

    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Box(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .size(dimensionResource(id = R.dimen.image_size))
            ) {
                Image(
                    painter = painterResource(R.drawable.teacher),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                )
            }
            Text(
                text = stringResource(R.string.are_you_ready),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier

            )
            SubjectLists(
                onArtAndCraftClick = onArtAndCraftClick,
                onEnglishClick = onEnglishClick,
                onGeneralKnowledgeClick = onGeneralKnowledgeClick,
                onGeographyClick = onGeographyClick,
                onMathematicsClick = onMathematicsClick,
                onReligiousStudyClick = onReligiousStudyClick,
            )
        }
    } else {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.padding_medium)
                )
            ) {
                Box(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_small))
                        .size(100.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.teacher),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
                Text(
                    text = stringResource(R.string.are_you_ready),
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier

                )

            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .padding(
                        end = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium)
                    )
                    .verticalScroll(rememberScrollState())
            ) {
                SubjectLists(
                    onArtAndCraftClick = onArtAndCraftClick,
                    onEnglishClick = onEnglishClick,
                    onGeneralKnowledgeClick = onGeneralKnowledgeClick,
                    onGeographyClick = onGeographyClick,
                    onMathematicsClick = onMathematicsClick,
                    onReligiousStudyClick = onReligiousStudyClick,
                )
            }
        }
    }
}

@Composable
fun SubjectLists(
    onEnglishClick: () -> Unit,
    onMathematicsClick: () -> Unit,
    onGeographyClick: () -> Unit,
    onArtAndCraftClick: () -> Unit,
    onReligiousStudyClick: () -> Unit,
    onGeneralKnowledgeClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Subject(
            subjectName = stringResource(R.string.art_and_craft),
            onClick = onArtAndCraftClick
        )
        Subject(
            subjectName = stringResource(R.string.english_language),
            onClick = onEnglishClick
        )
        Subject(
            subjectName = stringResource(R.string.general_knowledge),
            onClick = onGeneralKnowledgeClick
        )
        Subject(
            subjectName = stringResource(R.string.geography),
            onClick = onGeographyClick
        )
        Subject(
            subjectName = stringResource(R.string.mathematics),
            onClick = onMathematicsClick
        )
        Subject(
            subjectName = stringResource(R.string.religious_study),
            onClick = onReligiousStudyClick
        )
    }
}

@Composable
fun Subject(
    onClick: () -> Unit,
    subjectName: String,
    modifier: Modifier = Modifier
) {
    TextButton(onClick = onClick) {
        Text(
            text = subjectName,
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = modifier
                .border(2.5.dp, MaterialTheme.colorScheme.primary, MaterialTheme.shapes.small)
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium),
                    vertical = dimensionResource(id = R.dimen.padding_small)
                )


        )
    }
}


@Preview
@Composable
fun SubjectSelectionPreview() {
    QuizAppTheme {
        SubjectSelection(
            onEnglishClick = { /*TODO*/ },
            onMathematicsClick = { /*TODO*/ },
            onGeographyClick = { /*TODO*/ },
            onArtAndCraftClick = { /*TODO*/ },
            onReligiousStudyClick = { /*TODO*/ },
            onGeneralKnowledgeClick = { /*TODO*/ },
            navHostController = {}

        )
    }
}

@Preview(device = Devices.TABLET, showSystemUi = true)
@Composable
private fun SubjectScreenTabPreview() {
    QuizAppTheme {
        SubjectSelection(
            onEnglishClick = { /*TODO*/ },
            onMathematicsClick = { /*TODO*/ },
            onGeographyClick = { /*TODO*/ },
            onArtAndCraftClick = { /*TODO*/ },
            onReligiousStudyClick = { /*TODO*/ },
            onGeneralKnowledgeClick = { /*TODO*/ },
            navHostController = { /*TODO*/ }
        )
    }
}
