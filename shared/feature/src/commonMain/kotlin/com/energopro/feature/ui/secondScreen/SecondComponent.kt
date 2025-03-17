package com.energopro.feature.ui.secondScreen

import app.futured.arkitekt.decompose.ext.asStateFlow
import app.futured.factorygenerator.annotation.GenerateFactory
import com.energopro.feature.ui.base.AppComponentContext
import com.energopro.feature.ui.base.ScreenComponent
import com.energopro.feature.ui.picker.FruitPickerComponentFactory
import com.energopro.feature.ui.picker.Picker
import com.energopro.feature.ui.picker.PickerNavigation
import com.energopro.feature.ui.picker.VegetablePickerComponentFactory
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam

@GenerateFactory
@Factory
internal class SecondComponent(
    @InjectedParam componentContext: AppComponentContext,
    @InjectedParam override val navigation: SecondScreenNavigation,
) : ScreenComponent<SecondViewState, Nothing, SecondScreenNavigation>(
        componentContext = componentContext,
        defaultState = SecondViewState,
    ),
    SecondScreen,
    SecondScreenNavigation by navigation,
    SecondScreen.Actions {

    override val viewState: StateFlow<SecondViewState> = componentState
    override val actions: SecondScreen.Actions = this

    private val pickerNavigator = SlotNavigation<SecondScreen.PickerType>()
    private val pickerNavigation = PickerNavigation(
        dismiss = { result ->
            pickerNavigator.dismiss()
            if (result != null) {
                navigateToThird(result)
            }
        },
    )

    override val picker: StateFlow<ChildSlot<SecondScreen.PickerType, Picker>> = childSlot(
        source = pickerNavigator,
        serializer = SecondScreen.PickerType.serializer(),
        childFactory = { type, childContext ->
            when (type) {
                SecondScreen.PickerType.Fruit -> FruitPickerComponentFactory.createComponent(
                    componentContext = childContext,
                    navigation = pickerNavigation,
                )

                SecondScreen.PickerType.Vegetable -> VegetablePickerComponentFactory.createComponent(
                    componentContext = childContext,
                    navigation = pickerNavigation,
                )
            }
        },
    ).asStateFlow()

    override fun onBack() = pop()

    override fun onPickVeggie() = pickerNavigator.activate(SecondScreen.PickerType.Vegetable)

    override fun onPickFruit() = pickerNavigator.activate(SecondScreen.PickerType.Fruit)

    override fun onPickerDismissed() = pickerNavigator.dismiss()
}
