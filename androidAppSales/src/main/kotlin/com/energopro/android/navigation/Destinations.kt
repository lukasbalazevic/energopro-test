package com.energopro.android.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import com.energopro.android.ui.screen.login.LoginScreen
import com.energopro.android.ui.screen.menu.MenuScreen
import com.energopro.android.ui.screen.contacts.ContactsScreen
import com.energopro.android.ui.screen.help.HelpScreen
import com.energopro.android.ui.screen.map.MapScreen
import com.energopro.android.ui.screen.pod.PodScreen
import com.energopro.android.ui.screen.rewards.RewardsScreen
import com.energopro.android.ui.screen.settings.SettingsScreen
import com.energopro.android.ui.screen.recontract.search.RecontractSearchScreen
import com.energopro.android.ui.screen.recontract.form.RecontractFormScreen


typealias DestinationArgumentKey = String
typealias DestinationArgumentValue = String

internal val screens = listOf(
    Destination.Home,
    Destination.Login,
    Destination.Menu,
    Destination.Contacts,
    Destination.Help,
    Destination.Map,
    Destination.Pod,
    Destination.Rewards,
    Destination.Settings,
    Destination.RecontractSearch,
    Destination.RecontractForm
)

internal val dialogs = listOf<Destination>()

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList(),
    val deepLinks: List<NavDeepLink> = emptyList(),
    val destinationScreen: @Composable (router: NavRouter) -> Unit,
) {

    data object Home : Destination(
        route = "${Transitions.RoutePrefix.NORMAL_}home",
        destinationScreen = { Box(Modifier) {
            Text("Home", modifier = Modifier.align(Alignment.Center))
        } },
    )

    data object Login : Destination(
        route = "${Transitions.RoutePrefix.NORMAL_}login",
        destinationScreen = { Box(Modifier) {
            LoginScreen(it)
        } },
    )

    data object Menu : Destination(
        route = "${Transitions.RoutePrefix.NORMAL_}menu",
        destinationScreen = { Box(Modifier) {
            MenuScreen(it)
        } },
    )

    data object Contacts : Destination(
        route = "${Transitions.RoutePrefix.NORMAL_}contacts",
        destinationScreen = { Box(Modifier) {
            ContactsScreen(it)
        } },
    )

    data object Help : Destination(
        route = "${Transitions.RoutePrefix.NORMAL_}help",
        destinationScreen = { Box(Modifier) {
            HelpScreen(it)
        } },
    )

    data object Map : Destination(
        route = "${Transitions.RoutePrefix.NORMAL_}map",
        destinationScreen = { Box(Modifier) {
            MapScreen(it)
        } },
    )

    data object Pod : Destination(
        route = "${Transitions.RoutePrefix.NORMAL_}pod",
        destinationScreen = { Box(Modifier) {
            PodScreen(it)
        } },
    )

    data object Rewards : Destination(
        route = "${Transitions.RoutePrefix.NORMAL_}rewards",
        destinationScreen = { Box(Modifier) {
            RewardsScreen(it)
        } },
    )

    data object Settings : Destination(
        route = "${Transitions.RoutePrefix.NORMAL_}settings",
        destinationScreen = { Box(Modifier) {
            SettingsScreen(it)
        } },
    )

    data object RecontractSearch : Destination(
        route = "${Transitions.RoutePrefix.NORMAL_}recontract_search",
        destinationScreen = { Box(Modifier) {
            RecontractSearchScreen(it)
        } },
    )

    data object RecontractForm : Destination(
        route = "${Transitions.RoutePrefix.NORMAL_}recontract_form",
        destinationScreen = { Box(Modifier) {
            RecontractFormScreen(it)
        } },
    )
}


/**
 * Registers provided [destination] as a composable in [NavGraphBuilder].
 */
fun NavGraphBuilder.composableScreen(
    destination: Destination,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
) = composable(
    route = destination.route,
    arguments = destination.arguments,
    deepLinks = destination.deepLinks,
    enterTransition = Transitions.enterTransition,
    exitTransition = Transitions.exitTransition,
    popEnterTransition = Transitions.popEnterTransition,
    popExitTransition = Transitions.popExitTransition,
    content = content,
)

/**
 * Registers provided [destination] as a dialog in [NavGraphBuilder].
 */
fun NavGraphBuilder.composableDialog(
    destination: Destination,
    dialogProperties: DialogProperties = DialogProperties(),
    content: @Composable (NavBackStackEntry) -> Unit,
) = dialog(
    route = destination.route,
    arguments = destination.arguments,
    deepLinks = destination.deepLinks,
    dialogProperties = dialogProperties,
    content = content,
)

/**
 * Replaces an argument placeholder defined by [key] in
 * route string with value provided in [argument].
 *
 * Example:
 * Route: "emptyScreen/{title}"
 * key: "title"
 * argument: "Hello"
 * Result: "emptyScreen/Hello"
 */
@Suppress("unused")
fun String.withArgument(key: DestinationArgumentKey, argument: DestinationArgumentValue?) =
    argument?.let { replace("{$key}", it) } ?: this
