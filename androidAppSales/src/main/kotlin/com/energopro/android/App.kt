package com.energopro.android

import android.app.Application
import com.energopro.android.injection.modules.SalesModule
import com.energopro.android.tools.binding.PlatformBindingsImpl
import org.koin.android.ext.koin.androidContext
import org.koin.ksp.generated.module
import timber.log.Timber
import com.energopro.app.KmpApplication as SharedApp

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKmp()
        initializeLogging()
    }

    private fun initializeKmp() {
        SharedApp.initializeSharedApplication(
            platformBindings = PlatformBindingsImpl(applicationContext = this),
        ) {
            androidContext(this@App)
            modules(SalesModule().module)
        }
    }

    private fun initializeLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
