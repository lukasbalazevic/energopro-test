package com.energopro.android.ui.screen.menu

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
fun MenuScreen(
    navigation: NavRouter,
    viewModel: MenuViewModel = koinViewModel(),
) {
    with(viewModel) {
        EventsEffect {
            onEvent<NavigateToContactsEvent> {
                navigation.navigateToContacts()
            }
            onEvent<NavigateToHelpEvent> {
                navigation.navigateToHelp()
            }
            onEvent<NavigateToMapEvent> {
                navigation.navigateToMap()
            }
            onEvent<NavigateToPodEvent> {
                navigation.navigateToPod()
            }
            onEvent<NavigateToRecontractSearchEvent> {
                navigation.navigateToRecontractSearch()
            }
            onEvent<NavigateToRewardsEvent> {
                navigation.navigateToRewards()
            }
            onEvent<NavigateToSettingsEvent> {
                navigation.navigateToSettings()
            }
        }

        Menu.Content(
            actions = this,
        )
    }
}

object Menu {
    @Stable
    interface Actions {
        fun onNavigateToContacts()
        fun onNavigateToHelp()
        fun onNavigateToMap()
        fun onNavigateToPod()
        fun onNavigateToRecontractSearch()
        fun onNavigateToRewards()
        fun onNavigateToSettings()
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
                    title = { Text(text = "Menu") },
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
                Button(onClick = { actions.onNavigateToContacts() }) {
                    Text("Go to Contacts")
                }
                Button(onClick = { actions.onNavigateToHelp() }) {
                    Text("Go to Help")
                }
                Button(onClick = { actions.onNavigateToMap() }) {
                    Text("Go to Map")
                }
                Button(onClick = { actions.onNavigateToPod() }) {
                    Text("Go to Pod")
                }
                Button(onClick = { actions.onNavigateToRecontractSearch() }) {
                    Text("Go to Recontract Search")
                }
                Button(onClick = { actions.onNavigateToRewards() }) {
                    Text("Go to Rewards")
                }
                Button(onClick = { actions.onNavigateToSettings() }) {
                    Text("Go to Settings")
                }
            }
        }
    }
}

@ScreenPreviews
@Composable
private fun MenuContentPreview() = Showcase {
    Menu.Content(
        actions = object : Menu.Actions {
            override fun onNavigateToContacts() {}
            override fun onNavigateToHelp() {}
            override fun onNavigateToMap() {}
            override fun onNavigateToPod() {}
            override fun onNavigateToRecontractSearch() {}
            override fun onNavigateToRewards() {}
            override fun onNavigateToSettings() {}
        }
    )
}
