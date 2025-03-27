package com.energopro.android.ui.screen.recontract.form

import com.energopro.android.tools.arch.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class RecontractFormViewModel(
    override val viewState: RecontractFormViewState,
) : BaseViewModel<RecontractFormViewState>(), RecontractForm.Actions {
    override fun onNavigateBack() {
        sendEvent(NavigateBackEvent)
    }
    
    override fun onFormSubmitted(formData: Map<String, String>) {
        sendEvent(FormSubmittedEvent(formData))
    }
} 