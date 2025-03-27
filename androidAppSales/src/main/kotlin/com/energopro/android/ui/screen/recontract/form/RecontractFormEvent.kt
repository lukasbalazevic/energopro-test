package com.energopro.android.ui.screen.recontract.form

import app.futured.arkitekt.core.event.Event

sealed class RecontractFormEvent : Event<RecontractFormViewState>()
data object NavigateBackEvent : RecontractFormEvent()
data class FormSubmittedEvent(val formData: Map<String, String>) : RecontractFormEvent() 