package com.energopro.android.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.energopro.android.tools.extensions.subscribeForResult
import timber.log.Timber

class NavRouterImpl(private val navController: NavController) : NavRouter {
    override fun popBackStack() {
        navController.navigateUp()
    }

    override fun navigateBack(popUpToDestination: Destination, inclusive: Boolean) {
        navController.popBackStack(route = popUpToDestination.route, inclusive = inclusive)
    }

    override fun <T> navigateBackWithResult(key: String, value: T) {
        navController.previousBackStackEntry?.savedStateHandle?.also {
            it[key] = value
            navController.popBackStack()
        }
    }

    override fun <T> setCurrentResult(key: String, value: T) {
        navController.currentBackStackEntry?.savedStateHandle?.also {
            it[key] = value
        }
    }

    override fun <T> subscribeForResult(key: String, callback: (T) -> Unit) {
        navController.currentBackStackEntry?.savedStateHandle?.subscribeForResult<T>(key) { callback(it) }
    }

    override fun navigateToLogin() {
        navController.navigate(Destination.Login.route)
    }

    override fun navigateToMenu() {
        navController.navigate(
            Destination.Menu.route,
            navOptions = NavOptions.Builder().setPopUpTo(route = Destination.Menu.route, false).build(),
        )
    }

    override fun navigateToContacts() {
        navController.navigate(Destination.Contacts.route)
    }

    override fun navigateToHelp() {
        navController.navigate(Destination.Help.route)
    }

    override fun navigateToMap() {
        navController.navigate(Destination.Map.route)
    }

    override fun navigateToPod() {
        navController.navigate(Destination.Pod.route)
    }

    override fun navigateToRewards() {
        navController.navigate(Destination.Rewards.route)
    }

    override fun navigateToSettings() {
        navController.navigate(Destination.Settings.route)
    }

    override fun navigateToRecontractSearch() {
        navController.navigate(Destination.RecontractSearch.route)
    }

    override fun navigateToRecontractForm() {
        navController.navigate(Destination.RecontractForm.route)
    }

    private fun String.execute(
        popUpToDestinationRoute: String? = null,
        isInclusive: Boolean = true,
    ) {
        Timber.d("## Navigate to $this, popupTo $popUpToDestinationRoute, inclusive $isInclusive")
        if (popUpToDestinationRoute != null) {
            navController.navigate(this) {
                popUpTo(popUpToDestinationRoute) {
                    inclusive = isInclusive
                }
            }
        } else {
            navController.navigate(this)
        }
    }
}
