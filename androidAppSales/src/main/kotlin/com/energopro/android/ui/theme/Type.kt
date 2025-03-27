package com.energopro.android.ui.theme


import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Typography as DefaultTypography

val typography = DefaultTypography(
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
)

data class Typography(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val heading3: TextStyle,
    val heading4: TextStyle,
    // heading 5
    // heading 6

    val paragraphSmall: TextStyle,

    val large: TextStyle,
    val medium: TextStyle,
    val mediumSemiBold: TextStyle,
    val small: TextStyle,
    val smallSemiBold: TextStyle,
    val extraSmall: TextStyle,
    val extraSmallMedium: TextStyle,
    val extraSmallBold: TextStyle,
)

internal fun customTypography() = run {

    Typography(
        heading1 = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W700,
            fontSize = 32.sp,
            lineHeight = 38.4.sp,
        ),
        heading2 = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W700,
            fontSize = 24.sp,
            lineHeight = 28.8.sp,
        ),
        heading3 = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W700,
            fontSize = 18.sp,
            lineHeight = 28.8.sp,
        ),
        heading4 = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W600,
            fontSize = 16.sp,
            lineHeight = 28.8.sp,
        ),
        large = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W400,
            fontSize = 18.sp,
            lineHeight = 27.sp,
        ),
        medium = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            lineHeight = 25.sp,
        ),
        mediumSemiBold = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W600,
            fontSize = 16.sp,
            lineHeight = 24.sp,
        ),
        small = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            lineHeight = 21.sp,
        ),
        smallSemiBold = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W600,
            fontSize = 14.sp,
            lineHeight = 21.sp,
        ),
        paragraphSmall= TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            lineHeight = 21.sp,
        ),
        extraSmall = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
            lineHeight = 21.sp,
        ),
        extraSmallMedium = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W500,
            fontSize = 12.sp,
            lineHeight = 18.sp,
        ),
        extraSmallBold = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W700,
            fontSize = 12.sp,
            lineHeight = 14.sp,
        ),
    )
}

