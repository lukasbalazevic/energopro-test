package com.energopro.android.ui.screen.recontract.search

import app.futured.arkitekt.core.event.Event

sealed class RecontractSearchEvent : Event<RecontractSearchViewState>()
data object NavigateBackEvent : RecontractSearchEvent()
data class SearchResultSelectedEvent(val resultId: String) : RecontractSearchEvent() 