package com.energopro.android.ui.screen.recontract.search

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
fun RecontractSearchScreen(
    navigation: NavRouter,
    viewModel: RecontractSearchViewModel = koinViewModel(),
) {
    with(viewModel) {
        EventsEffect {
            onEvent<NavigateBackEvent> {
                navigation.popBackStack()
            }
            onEvent<SearchResultSelectedEvent> { event ->
                // Handle search result selection
            }
        }

        RecontractSearch.Content(
            actions = this,
        )
    }
}

object RecontractSearch {
    @Stable
    interface Actions {
        fun onNavigateBack()
        fun onSearchResultSelected(resultId: String)
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
                    title = { Text(text = "Recontract Search") },
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
                Button(onClick = { actions.onSearchResultSelected("result1") }) {
                    Text("Search Result 1")
                }
                Button(onClick = { actions.onSearchResultSelected("result2") }) {
                    Text("Search Result 2")
                }
            }
        }
    }
}

@ScreenPreviews
@Composable
private fun RecontractSearchContentPreview() = Showcase {
    RecontractSearch.Content(
        actions = object : RecontractSearch.Actions {
            override fun onNavigateBack() = Unit
            override fun onSearchResultSelected(resultId: String) = Unit
        },
    )
} 