package com.energopro.android.navigation

interface NavRouter {
    fun popBackStack()
    fun navigateBack(popUpToDestination: Destination, inclusive: Boolean = false)


    fun navigateToHome()
    fun navigateToLogin()

    fun <T> navigateBackWithResult(key: String, value: T)
    fun <T> setCurrentResult(key: String, value: T)
    fun <T> subscribeForResult(key: String, callback: (T) -> Unit)
}
