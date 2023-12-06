package com.example.quizapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.quizapp.R

val Roboto = FontFamily(
    Font(R.font.roboto_light),
    Font(R.font.roboto_regular),
    Font(R.font.roboto_medium, FontWeight.Bold),
    Font(R.font.roboto_black, FontWeight.ExtraBold)
)

val Open_Sans = FontFamily(
    Font(R.font.open_sans_light),
    Font(R.font.open_sans_regular),
    Font(R.font.open_sans_medium, FontWeight.Bold),
    Font(R.font.open_sans_bold, FontWeight.ExtraBold)
)

// Set of Material typography styles to start with
val QuizAppTypography = Typography(
    headlineSmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Open_Sans,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Open_Sans,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp,
    ),
    displayLarge = TextStyle(
        fontFamily = Open_Sans,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
    )

)