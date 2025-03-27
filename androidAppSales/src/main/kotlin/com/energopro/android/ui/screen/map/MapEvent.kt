package com.energopro.android.ui.screen.map

import app.futured.arkitekt.core.event.Event

sealed class MapEvent : Event<MapViewState>()
data object NavigateBackEvent : MapEvent()
data class LocationSelectedEvent(val locationId: String) : MapEvent() 