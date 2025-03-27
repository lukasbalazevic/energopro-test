package com.energopro.android.ui.screen.help

import app.futured.arkitekt.core.event.Event

sealed class HelpEvent : Event<HelpViewState>()
data object NavigateBackEvent : HelpEvent()
data class HelpItemSelectedEvent(val itemId: String) : HelpEvent() 