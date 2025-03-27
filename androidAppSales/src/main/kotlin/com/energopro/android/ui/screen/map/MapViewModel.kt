package com.energopro.android.ui.screen.map

import com.energopro.android.tools.arch.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MapViewModel(
    override val viewState: MapViewState,
) : BaseViewModel<MapViewState>(), Map.Actions {
    override fun onNavigateBack() {
        sendEvent(NavigateBackEvent)
    }
    
    override fun onLocationSelected(locationId: String) {
        sendEvent(LocationSelectedEvent(locationId))
    }
} 