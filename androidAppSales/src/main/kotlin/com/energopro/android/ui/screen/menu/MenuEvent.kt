package com.energopro.android.ui.screen.menu

import app.futured.arkitekt.core.event.Event

sealed class MenuEvent : Event<MenuViewState>()
data object NavigateBackEvent : MenuEvent()
data class MenuItemSelectedEvent(val itemId: String) : MenuEvent() 