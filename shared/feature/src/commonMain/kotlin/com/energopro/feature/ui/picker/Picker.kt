package com.energopro.feature.ui.picker

import kotlinx.coroutines.flow.StateFlow

interface Picker {
    val viewState: StateFlow<PickerState>
    val actions: Actions

    interface Actions {
        fun onPick(item: String)
        fun onDismiss()
    }
}
