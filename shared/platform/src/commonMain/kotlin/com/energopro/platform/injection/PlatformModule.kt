package com.energopro.platform.injection

import com.energopro.platform.binding.Platform
import com.energopro.platform.binding.PlatformBindings
import org.koin.dsl.bind
import org.koin.dsl.module

fun platformModule(
    platformBindings: PlatformBindings,
) = module {
    includes(kotlinPlatformModule())

    single { platformBindings.platform() } bind Platform::class
}
