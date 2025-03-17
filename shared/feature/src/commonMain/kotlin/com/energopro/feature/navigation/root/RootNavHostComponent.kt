package com.energopro.feature.navigation.root

import app.futured.arkitekt.decompose.ext.asStateFlow
import com.energopro.feature.navigation.deepLink.DeepLinkDestination
import com.energopro.feature.navigation.deepLink.DeepLinkResolver
import com.energopro.feature.navigation.signedIn.SignedInNavHostComponentFactory
import com.energopro.feature.ui.base.AppComponent
import com.energopro.feature.ui.base.AppComponentContext
import com.energopro.feature.ui.loginScreen.LoginComponentFactory
import com.energopro.feature.ui.thirdScreen.ThirdScreenArgs
import co.touchlab.kermit.Logger
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam

@Factory
internal class RootNavHostComponent(
    @InjectedParam componentContext: AppComponentContext,
    private val deepLinkResolver: DeepLinkResolver,
) : AppComponent<RootNavHostViewState, Nothing>(componentContext, RootNavHostViewState), RootNavHost {

    private val rootNavigator: RootNavHostNavigation = RootNavHostNavigator()
    private var pendingDeepLink: DeepLinkDestination? = null

    private val logger = Logger.withTag("RootNavHostComponent")

    override val slot: StateFlow<ChildSlot<RootConfig, RootChild>> = childSlot(
        source = rootNavigator.slotNavigator,
        serializer = RootConfig.serializer(),
        initialConfiguration = { null },
        handleBackButton = false,
        childFactory = { config, childCtx ->
            when (config) {
                RootConfig.Login -> RootChild.Login(
                    LoginComponentFactory.createComponent(
                        childCtx,
                        rootNavigator,
                    ),
                )

                is RootConfig.SignedIn -> RootChild.SignedIn(
                    navHost = SignedInNavHostComponentFactory.createComponent(
                        componentContext = childCtx,
                        navigationToLogin = { rootNavigator.slotNavigator.activate(RootConfig.Login) },
                        initialConfig = config.initialConfig,
                    ),
                )
            }
        },
    ).asStateFlow()

    init {
        doOnCreate {
            if (!consumeDeepLink()) {
                rootNavigator.slotNavigator.activate(RootConfig.Login)
            }
        }
    }

    override val actions: RootNavHost.Actions = object : RootNavHost.Actions {
        override fun onDeepLink(uri: String) {
            val deepLinkDestination = deepLinkResolver.resolve(uri) ?: return
            pendingDeepLink = deepLinkDestination
            consumeDeepLink()
        }
    }

    /**
     * Consumes pending deep links.
     *
     * @return `true` if deep link was consumed, or `false` if there was no deep link to consume.
     */
    private fun consumeDeepLink(): Boolean {
        val deepLink = pendingDeepLink ?: return false
        val deepLinkConfig = when (deepLink) {
            DeepLinkDestination.HomeTab -> RootConfig.deepLinkHome()
            DeepLinkDestination.ProfileTab -> RootConfig.deepLinkProfile()
            DeepLinkDestination.SecondScreen -> RootConfig.deepLinkSecondScreen()
            is DeepLinkDestination.ThirdScreen -> RootConfig.deepLinkThirdScreen(ThirdScreenArgs(deepLink.argument))
        }
        rootNavigator.slotNavigator.activate(deepLinkConfig)
        return true
    }
}
