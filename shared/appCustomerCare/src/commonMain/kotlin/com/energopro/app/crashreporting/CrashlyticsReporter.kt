package com.energopro.app.crashreporting

import com.energopro.platform.binding.PlatformFirebaseCrashlytics

/**
 * Class responsible for recording crashlytics errors using provided [PlatformFirebaseCrashlytics] binding.
 */
internal expect class CrashlyticsReporter(crashlytics: PlatformFirebaseCrashlytics) {
    fun logMessage(message: String)
    fun sendNonFatalException(throwable: Throwable)
}
