package com.energopro.android.navigation

import androidx.navigation.NavController
import com.energopro.android.tools.extensions.subscribeForResult
import timber.log.Timber

class NavRouterImpl(private val navController: NavController) : NavRouter {
    override fun popBackStack() {
        navController.navigateUp()
    }

    override fun navigateBack(popUpToDestination: Destination, inclusive: Boolean) {
        navController.popBackStack(route = popUpToDestination.route, inclusive = inclusive)
    }

    override fun navigateToHome() {
        Destination.Login.route.execute(popUpToDestinationRoute = Destination.Home.route)
    }

    override fun navigateToLogin() {
        TODO("Not yet implemented")
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
