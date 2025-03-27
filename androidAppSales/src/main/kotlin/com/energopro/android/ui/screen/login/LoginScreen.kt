package com.energopro.android.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
fun LoginScreen(
    navigation: NavRouter,
    viewModel: LoginViewModel = koinViewModel(),
) {
    with(viewModel) {
        EventsEffect {
            onEvent<NavigateBackEvent> {
                navigation.popBackStack()
            }

            onEvent<NavigateToMenuEvent> {
                navigation.navigateToMenu()
            }
        }

        Login.Content(
            actions = this,
        )
    }
}

object Login {
    @Stable
    interface Actions {
        fun onNavigateToMenu()
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
                    title = { Text(text = "LoginScreen") },
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
                Button(onClick = { actions.onNavigateToMenu() }) {
                    Text("Go to Menu")
                }
            }
        }
    }
}

@ScreenPreviews
@Composable
private fun LoginContentPreview() = Showcase {
    Login.Content(
        actions = object : Login.Actions {
            override fun onNavigateToMenu() = Unit
        },
    )
}

