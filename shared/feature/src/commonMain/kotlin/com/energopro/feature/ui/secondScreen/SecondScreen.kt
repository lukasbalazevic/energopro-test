package com.energopro.feature.ui.secondScreen

import com.energopro.feature.ui.picker.Picker
import com.arkivanov.decompose.router.slot.ChildSlot
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable

interface SecondScreen {

    val viewState: StateFlow<SecondViewState>
    val actions: Actions
    val picker: StateFlow<ChildSlot<PickerType, Picker>>

    @Serializable
    sealed interface PickerType {
        data object Fruit : PickerType
        data object Vegetable : PickerType
    }

    interface Actions {
        fun onBack()
        fun onPickFruit()
        fun onPickVeggie()
        fun onPickerDismissed()
    }
}
