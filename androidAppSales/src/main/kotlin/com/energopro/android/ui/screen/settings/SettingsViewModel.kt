package com.energopro.android.ui.screen.settings

import com.energopro.android.tools.arch.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SettingsViewModel(
    override val viewState: SettingsViewState,
) : BaseViewModel<SettingsViewState>(), Settings.Actions {
    override fun onNavigateBack() {
        sendEvent(NavigateBackEvent)
    }
    
    override fun onSettingItemSelected(itemId: String) {
        sendEvent(SettingItemSelectedEvent(itemId))
    }
} 