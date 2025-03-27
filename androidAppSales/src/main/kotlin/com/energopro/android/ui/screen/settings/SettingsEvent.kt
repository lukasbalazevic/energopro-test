package com.energopro.android.ui.screen.settings

import app.futured.arkitekt.core.event.Event

sealed class SettingsEvent : Event<SettingsViewState>()
data object NavigateBackEvent : SettingsEvent()
data class SettingItemSelectedEvent(val itemId: String) : SettingsEvent() 