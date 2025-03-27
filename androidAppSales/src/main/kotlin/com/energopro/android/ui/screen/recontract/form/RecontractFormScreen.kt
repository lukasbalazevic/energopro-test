package com.energopro.android.ui.screen.recontract.form

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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.energopro.android.navigation.NavRouter
import com.energopro.android.tools.arch.EventsEffect
import com.energopro.android.tools.arch.onEvent
import com.energopro.android.tools.compose.ScreenPreviews
import com.energopro.android.ui.components.Showcase
import org.koin.androidx.compose.koinViewModel

@Composable
fun RecontractFormScreen(
    navigation: NavRouter,
    viewModel: RecontractFormViewModel = koinViewModel(),
) {
    with(viewModel) {
        EventsEffect {
            onEvent<NavigateBackEvent> {
                navigation.popBackStack()
            }
            onEvent<FormSubmittedEvent> { event ->
                // Handle form submission
            }
        }

        RecontractForm.Content(
            actions = this,
        )
    }
}

object RecontractForm {
    @Stable
    interface Actions {
        fun onNavigateBack()
        fun onFormSubmitted(formData: Map<String, String>)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Content(
        actions: Actions,
        modifier: Modifier = Modifier,
    ) {
        val name = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Recontract Form") },
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
                TextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text("Name") }
                )
                TextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text("Email") }
                )
                Button(onClick = { actions.onFormSubmitted(mapOf("name" to name.value, "email" to email.value)) }) {
                    Text("Submit")
                }
            }
        }
    }
}

@ScreenPreviews
@Composable
private fun RecontractFormContentPreview() = Showcase {
    RecontractForm.Content(
        actions = object : RecontractForm.Actions {
            override fun onNavigateBack() = Unit
            override fun onFormSubmitted(formData: Map<String, String>) = Unit
        },
    )
} 