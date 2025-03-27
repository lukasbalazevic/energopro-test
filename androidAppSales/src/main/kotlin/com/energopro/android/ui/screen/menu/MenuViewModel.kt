package com.energopro.android.ui.screen.menu

import com.energopro.android.tools.arch.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MenuViewModel(
    override val viewState: MenuViewState,
) : BaseViewModel<MenuViewState>(), Menu.Actions {
    override fun onNavigateBack() {
        sendEvent(NavigateBackEvent)
    }
    
    override fun onMenuItemSelected(itemId: String) {
        sendEvent(MenuItemSelectedEvent(itemId))
    }
} 