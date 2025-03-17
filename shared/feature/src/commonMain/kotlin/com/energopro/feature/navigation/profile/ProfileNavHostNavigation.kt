package com.energopro.feature.navigation.profile

import com.energopro.feature.ui.profileScreen.ProfileScreen
import com.energopro.feature.ui.profileScreen.ProfileScreenNavigation
import com.energopro.feature.ui.thirdScreen.ThirdComponent
import com.energopro.feature.ui.thirdScreen.ThirdScreenArgs
import com.energopro.feature.ui.thirdScreen.ThirdScreenNavigation
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push

internal interface ProfileNavHostNavigation : ProfileScreenNavigation, ThirdScreenNavigation {
    val stackNavigator: StackNavigation<ProfileConfig>
}

internal class ProfileNavHostNavigator(
    private val onNavigateToLogin: () -> Unit,
) : ProfileNavHostNavigation {
    override val stackNavigator = StackNavigation<ProfileConfig>()

    override fun ProfileScreen.navigateToLogin() = onNavigateToLogin()

    override fun ProfileScreen.navigateToThird(id: String) {
        stackNavigator.push(ProfileConfig.Third(ThirdScreenArgs(id)))
    }

    override fun ThirdComponent.pop() {
        stackNavigator.pop()
    }
}
