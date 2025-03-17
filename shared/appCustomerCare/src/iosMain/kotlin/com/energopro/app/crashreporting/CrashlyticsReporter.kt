package com.energopro.app.crashreporting

import com.energopro.platform.binding.PlatformFirebaseCrashlytics
import com.rickclephas.kmp.nsexceptionkt.core.asNSException

/**
 * Class responsible for recording crashlytics errors using provided [PlatformFirebaseCrashlytics] binding.
 */
internal actual class CrashlyticsReporter actual constructor(private val crashlytics: PlatformFirebaseCrashlytics) {

    actual fun logMessage(message: String) = crashlytics.logMessage(message)

    actual fun sendNonFatalException(throwable: Throwable) =
        crashlytics.sendNonFatalException(throwable.asNSException(appendCausedBy = true))

    fun raiseFatalException(throwable: Throwable) =
        crashlytics.raiseFatalException(throwable.asNSException(appendCausedBy = true))
}
