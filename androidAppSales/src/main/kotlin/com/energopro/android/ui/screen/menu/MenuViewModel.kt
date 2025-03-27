package com.energopro.android.ui.screen.menu

import com.energopro.android.tools.arch.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MenuViewModel(
    override val viewState: MenuViewState,
) : BaseViewModel<MenuViewState>(), Menu.Actions {

    override fun onNavigateToContacts() {
        sendEvent(NavigateToContactsEvent)
    }

    override fun onNavigateToHelp() {
        sendEvent(NavigateToHelpEvent)
    }

    override fun onNavigateToMap() {
        sendEvent(NavigateToMapEvent)
    }

    override fun onNavigateToPod() {
        sendEvent(NavigateToPodEvent)
    }

    override fun onNavigateToRecontractSearch() {
        sendEvent(NavigateToRecontractSearchEvent)
    }

    override fun onNavigateToRewards() {
        sendEvent(NavigateToRewardsEvent)
    }

    override fun onNavigateToSettings() {
        sendEvent(NavigateToSettingsEvent)
    }
}
