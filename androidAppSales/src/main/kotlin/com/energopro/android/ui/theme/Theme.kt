package com.energopro.android.ui.theme


import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LightColorPalette: ColorScheme
    @Composable get() = lightColorScheme(
        background = SalesTheme.colors.backgroundPrimary,
        surface = SalesTheme.colors.backgroundPrimary,
    )

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColors provides customColors(),
        LocalTypography provides customTypography(),
    ) {
        MaterialTheme(
            colorScheme = LightColorPalette,
            typography = typography,
            shapes = shapes,
            content = content,
        )
    }
}

object SalesTheme {

    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

internal val LocalColors = staticCompositionLocalOf<Colors> { error("No CustomColors were provided") }

internal val LocalTypography = staticCompositionLocalOf<Typography> { error("No CustomTypography was provided") }
