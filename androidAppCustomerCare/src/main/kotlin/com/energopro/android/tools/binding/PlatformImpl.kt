package com.energopro.android.tools.binding

import android.content.Context
import android.os.Build
import com.energopro.android.BuildConfig
import com.energopro.platform.binding.Platform
import com.energopro.resources.MR

class PlatformImpl(applicationContext: Context) : Platform {
    override val appName: String = MR.strings.template_app_name.getString(applicationContext)
    override val appVersionName: String = BuildConfig.VERSION_NAME
    override val appBuildNumber: String = BuildConfig.VERSION_CODE.toString()
    override val applicationId: String = BuildConfig.APPLICATION_ID
    override val osNameWithVersion: String = "Android ${Build.VERSION.RELEASE}"
    override val deviceModel: String = Build.MODEL
}
