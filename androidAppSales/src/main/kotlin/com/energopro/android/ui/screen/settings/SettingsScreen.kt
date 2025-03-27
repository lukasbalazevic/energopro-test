package com.energopro.android.ui.screen.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.energopro.android.navigation.NavRouter
import com.energopro.android.tools.arch.EventsEffect
import com.energopro.android.tools.arch.onEvent
import com.energopro.android.tools.compose.ScreenPreviews
import com.energopro.android.ui.components.Showcase
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsScreen(
    navigation: NavRouter,
    viewModel: SettingsViewModel = koinViewModel(),
) {
    with(viewModel) {
        EventsEffect {
            onEvent<NavigateBackEvent> {
                navigation.popBackStack()
            }
            onEvent<SettingItemSelectedEvent> { event ->
                // Handle setting item selection
            }
        }

        Settings.Content(
            actions = this,
        )
    }
}

object Settings {
    @Stable
    interface Actions {
        fun onNavigateBack()
        fun onSettingItemSelected(itemId: String)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Content(
        actions: Actions,
        modifier: Modifier = Modifier,
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Settings") },
                    navigationIcon = {
                        IconButton(
                            onClick = { actions.onNavigateBack() },
                        ) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, "")
                        }
                    },
                )
            },
            modifier = modifier,
        ) { contentPadding ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
            ) {
                Button(onClick = { actions.onSettingItemSelected("setting1") }) {
                    Text("Setting Item 1")
                }
                Button(onClick = { actions.onSettingItemSelected("setting2") }) {
                    Text("Setting Item 2")
                }
            }
        }
    }
}

@ScreenPreviews
@Composable
private fun SettingsContentPreview() = Showcase {
    Settings.Content(
        actions = object : Settings.Actions {
            override fun onNavigateBack() = Unit
            override fun onSettingItemSelected(itemId: String) = Unit
        },
    )
} 