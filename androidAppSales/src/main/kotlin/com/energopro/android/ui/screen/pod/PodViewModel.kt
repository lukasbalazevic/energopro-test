package com.energopro.android.ui.screen.pod

import com.energopro.android.tools.arch.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class PodViewModel(
    override val viewState: PodViewState,
) : BaseViewModel<PodViewState>(), Pod.Actions {
    override fun onNavigateBack() {
        sendEvent(NavigateBackEvent)
    }
    
    override fun onPodItemSelected(itemId: String) {
        sendEvent(PodItemSelectedEvent(itemId))
    }
} 