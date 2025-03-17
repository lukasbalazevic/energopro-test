package com.energopro.network.rest.plugin

import com.energopro.network.rest.FlavorConstants
import com.energopro.platform.binding.Platform
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.UserAgent
import org.koin.core.annotation.Single

@Single
internal class UserAgentPlugin(platform: Platform) : HttpClientPlugin {

    private val userAgentString = with(platform) {
        listOf(
            "$appName/$appVersionName",
            "($applicationId; build:$appBuildNumber; $osNameWithVersion; Model:$deviceModel)",
            "ktor-client/${FlavorConstants.ktorUserAgentVersion}",
        )
    }.joinToString(separator = " ")

    override fun install(config: HttpClientConfig<*>) {
        config.install(UserAgent) {
            agent = userAgentString
        }
    }
}
