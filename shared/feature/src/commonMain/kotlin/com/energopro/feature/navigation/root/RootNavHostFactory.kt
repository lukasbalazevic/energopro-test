package com.energopro.feature.navigation.root

import com.energopro.feature.ui.base.AppComponentContext
import com.energopro.feature.ui.base.AppComponentFactory
import org.koin.core.component.KoinComponent

object RootNavHostFactory : KoinComponent {
    fun create(
        componentContext: AppComponentContext,
    ): RootNavHost = AppComponentFactory.createAppComponent<RootNavHostComponent>(componentContext)
}
