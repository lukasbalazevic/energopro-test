package com.energopro.android.navigation

interface NavRouter {
    fun popBackStack()
    fun navigateBack(popUpToDestination: Destination, inclusive: Boolean = false)

    fun <T> navigateBackWithResult(key: String, value: T)
    fun <T> setCurrentResult(key: String, value: T)
    fun <T> subscribeForResult(key: String, callback: (T) -> Unit)

    fun navigateToLogin()
    fun navigateToMenu()
    fun navigateToContacts()
    fun navigateToHelp()
    fun navigateToMap()
    fun navigateToPod()
    fun navigateToRewards()
    fun navigateToSettings()
    fun navigateToRecontractSearch()
    fun navigateToRecontractForm()
}
