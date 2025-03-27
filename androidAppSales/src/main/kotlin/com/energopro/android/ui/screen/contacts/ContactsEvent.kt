package com.energopro.android.ui.screen.contacts

import app.futured.arkitekt.core.event.Event

sealed class ContactsEvent : Event<ContactsViewState>()
data object NavigateBackEvent : ContactsEvent()
data class ContactSelectedEvent(val contactId: String) : ContactsEvent() 