package com.energopro.android.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.energopro.android.navigation.Destination
import com.energopro.android.navigation.NavRouter
import com.energopro.android.navigation.NavRouterImpl
import com.energopro.android.navigation.composableDialog
import com.energopro.android.navigation.composableScreen
import com.energopro.android.navigation.dialogs
import com.energopro.android.navigation.screens

@SuppressLint("ComposeModifierMissing")
@Composable
fun NavGraph(
    isFirstRun: Boolean,
    navController: NavHostController = rememberNavController(),
    navigation: NavRouter = remember { NavRouterImpl(navController) },
) {
    val startDestination = if (isFirstRun) {
        Destination.Menu.route
    } else {
        Destination.Login.route
    }

    Scaffold(
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding),
        ) {
            // Destinations without navbar at the bottom
            screens.forEach { destination ->
                composableScreen(destination) { destination.destinationScreen(navigation) }
            }

            // Dialogs
            dialogs.forEach { destination ->
                composableDialog(destination) { destination.destinationScreen(navigation) }
            }
        }
    }
}
