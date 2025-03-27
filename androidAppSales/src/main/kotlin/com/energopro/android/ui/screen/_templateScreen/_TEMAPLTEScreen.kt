package com.energopro.android.ui.screen._templateScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import app.futured.arkitekt.core.ViewState
import app.futured.arkitekt.core.event.Event
import com.energopro.android.navigation.NavRouter
import com.energopro.android.tools.arch.BaseViewModel
import com.energopro.android.tools.arch.EventsEffect
import com.energopro.android.tools.arch.onEvent
import com.energopro.android.tools.compose.ScreenPreviews
import com.energopro.android.ui.components.Showcase
import org.koin.android.annotation.KoinViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.annotation.Factory

/**
 * This is a template for creating new screens:
 *
 * 1. Copy wherever you wanna create the screen.
 * 2. Select all occurrences of "TEMPLATE" (Ctrl + G) and rename to your liking.
 * 3. Extract all parts to respective files (alt+enter on interface/class signature -> extract from file).
 */
@Composable
fun TEMPLATEScreen(
    navigation: NavRouter,
    viewModel: TEMPLATEViewModel = koinViewModel(),
) {
    with(viewModel) {
        EventsEffect {
            onEvent<NavigateBackEvent> {
                navigation.popBackStack()
            }
        }

        TEMPLATE.Content(
            actions = this,
        )
    }
}

object TEMPLATE {
    @Stable
    interface Actions {
        fun onNavigateBack()
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
                    title = { Text(text = "TEMPLATEScreen") },
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
                Text(text = "TEMPLATE")
            }
        }
    }
}

@ScreenPreviews
@Composable
private fun TEMPLATEContentPreview() = Showcase {
    TEMPLATE.Content(
        actions = object : TEMPLATE.Actions {
            override fun onNavigateBack() = Unit
        },
    )
}

sealed class TEMPLATEEvent : Event<TEMPLATEViewState>()

data object NavigateBackEvent : TEMPLATEEvent()

@KoinViewModel
class TEMPLATEViewModel(
    override val viewState: TEMPLATEViewState,
) : BaseViewModel<TEMPLATEViewState>(), TEMPLATE.Actions {
    override fun onNavigateBack() {
        sendEvent(NavigateBackEvent)
    }
}

@Factory
class TEMPLATEViewState() : ViewState
