package com.energopro.android.ui.screen.pod

import app.futured.arkitekt.core.event.Event

sealed class PodEvent : Event<PodViewState>()
data object NavigateBackEvent : PodEvent()
data class PodItemSelectedEvent(val itemId: String) : PodEvent() 