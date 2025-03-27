package com.energopro.android.ui.screen.contacts

import com.energopro.android.tools.arch.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ContactsViewModel(
    override val viewState: ContactsViewState,
) : BaseViewModel<ContactsViewState>(), Contacts.Actions {
    override fun onNavigateBack() {
        sendEvent(NavigateBackEvent)
    }
    
    override fun onContactSelected(contactId: String) {
        sendEvent(ContactSelectedEvent(contactId))
    }
} 