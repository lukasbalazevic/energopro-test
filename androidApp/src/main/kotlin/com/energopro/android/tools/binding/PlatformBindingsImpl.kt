package com.energopro.android.tools.binding

import android.content.Context
import com.energopro.platform.binding.Platform
import com.energopro.platform.binding.PlatformBindings
import com.energopro.platform.binding.PlatformFirebaseCrashlytics

class PlatformBindingsImpl(private val applicationContext: Context) : PlatformBindings {
    override fun platform(): Platform = PlatformImpl(applicationContext)
    override fun firebaseCrashlytics(): PlatformFirebaseCrashlytics = PlatformFirebaseCrashlyticsImpl()
}
