package com.energopro.app

import com.energopro.app.crashreporting.AppCrashReporting
import com.energopro.app.crashreporting.CrashlyticsReporter
import com.energopro.app.injection.AppInjection
import com.energopro.app.logging.AppLogging
import com.energopro.platform.binding.PlatformBindings
import org.koin.dsl.KoinAppDeclaration

/**
 * Shared KMP entrypoint.
 *
 * Initializes injection framework,
 */
object KmpApplication {

    fun initializeSharedApplication(
        platformBindings: PlatformBindings,
        appDeclaration: KoinAppDeclaration? = null,
    ) {
        val crashlyticsReporter = CrashlyticsReporter(platformBindings.firebaseCrashlytics())

        AppInjection.initializeInjection(
            platformBindings = platformBindings,
            appDeclaration = appDeclaration,
        )
        AppCrashReporting.initialize(crashlyticsReporter)
        AppLogging.initialize(crashlyticsReporter)
    }
}
