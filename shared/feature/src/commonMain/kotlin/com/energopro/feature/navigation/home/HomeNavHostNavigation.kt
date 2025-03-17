package com.energopro.feature.navigation.home

import com.energopro.feature.ui.firstScreen.FirstComponent
import com.energopro.feature.ui.firstScreen.FirstScreenNavigation
import com.energopro.feature.ui.secondScreen.SecondComponent
import com.energopro.feature.ui.secondScreen.SecondScreenNavigation
import com.energopro.feature.ui.thirdScreen.ThirdComponent
import com.energopro.feature.ui.thirdScreen.ThirdScreenArgs
import com.energopro.feature.ui.thirdScreen.ThirdScreenNavigation
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew

internal interface HomeNavHostNavigation : FirstScreenNavigation, SecondScreenNavigation, ThirdScreenNavigation {
    val navigator: StackNavigation<HomeConfig>
}

internal class HomeNavigator : HomeNavHostNavigation {
    override val navigator = StackNavigation<HomeConfig>()

    override fun FirstComponent.navigateToSecond() =
        navigator.pushNew(HomeConfig.Second)

    override fun SecondComponent.pop() =
        navigator.pop()

    override fun SecondComponent.navigateToThird(id: String) =
        navigator.pushNew(HomeConfig.Third(ThirdScreenArgs(id)))

    override fun ThirdComponent.pop() {
        navigator.pop()
    }
}
