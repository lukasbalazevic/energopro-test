package com.energopro.android.ui.screen.help

import com.energopro.android.tools.arch.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HelpViewModel(
    override val viewState: HelpViewState,
) : BaseViewModel<HelpViewState>(), Help.Actions {
    override fun onNavigateBack() {
        sendEvent(NavigateBackEvent)
    }
    
    override fun onHelpItemSelected(itemId: String) {
        sendEvent(HelpItemSelectedEvent(itemId))
    }
} 