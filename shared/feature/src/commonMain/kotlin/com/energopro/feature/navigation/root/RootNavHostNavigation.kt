package com.energopro.feature.navigation.root

import com.energopro.feature.navigation.signedIn.SignedInNavHostComponent
import com.energopro.feature.navigation.signedIn.SignedInNavHostNavigation
import com.energopro.feature.ui.loginScreen.LoginComponent
import com.energopro.feature.ui.loginScreen.LoginScreenNavigation
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate

internal interface RootNavHostNavigation : LoginScreenNavigation, SignedInNavHostNavigation {
    val slotNavigator: SlotNavigation<RootConfig>
}

internal class RootNavHostNavigator : RootNavHostNavigation {
    override val slotNavigator: SlotNavigation<RootConfig> = SlotNavigation()

    override fun LoginComponent.navigateToSignedIn() {
        slotNavigator.activate(RootConfig.SignedIn())
    }

    override fun SignedInNavHostComponent.navigateToLogin() {
        slotNavigator.activate(RootConfig.Login)
    }
}
