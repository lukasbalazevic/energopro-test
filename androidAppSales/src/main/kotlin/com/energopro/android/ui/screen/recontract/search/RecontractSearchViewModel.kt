package com.energopro.android.ui.screen.recontract.search

import com.energopro.android.tools.arch.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class RecontractSearchViewModel(
    override val viewState: RecontractSearchViewState,
) : BaseViewModel<RecontractSearchViewState>(), RecontractSearch.Actions {
    override fun onNavigateBack() {
        sendEvent(NavigateBackEvent)
    }
    
    override fun onSearchResultSelected(resultId: String) {
        sendEvent(SearchResultSelectedEvent(resultId))
    }
} 