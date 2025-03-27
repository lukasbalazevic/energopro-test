package com.energopro.android.ui.screen.login

import com.energopro.android.tools.arch.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class LoginViewModel(
    override val viewState: LoginViewState,
) : BaseViewModel<LoginViewState>(), Login.Actions {
    override fun onNavigateToMenu() {
       sendEvent(NavigateToMenuEvent)
    }
}
