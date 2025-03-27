package com.energopro.android.ui.screen.login

import app.futured.arkitekt.core.event.Event

sealed class LoginEvent : Event<LoginViewState>()
data object NavigateBackEvent : LoginEvent()
