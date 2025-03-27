package com.energopro.android.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.energopro.android.ui.theme.AppTheme

/**
 * Preview surface wrapper
 */
@Composable
fun Showcase(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    AppTheme {
        Surface(color = MaterialTheme.colorScheme.background, modifier = modifier) {
            content()
        }
    }
}
