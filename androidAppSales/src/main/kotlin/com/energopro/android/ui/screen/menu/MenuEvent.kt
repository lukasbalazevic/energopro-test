package com.energopro.android.ui.screen.menu

import app.futured.arkitekt.core.event.Event

sealed class MenuEvent : Event<MenuViewState>()
data object NavigateBackEvent : MenuEvent()
data object NavigateToContactsEvent : MenuEvent()
data object NavigateToHelpEvent : MenuEvent()
data object NavigateToMapEvent : MenuEvent()
data object NavigateToPodEvent : MenuEvent()
data object NavigateToRecontractSearchEvent : MenuEvent()
data object NavigateToRewardsEvent : MenuEvent()
data object NavigateToSettingsEvent : MenuEvent()
