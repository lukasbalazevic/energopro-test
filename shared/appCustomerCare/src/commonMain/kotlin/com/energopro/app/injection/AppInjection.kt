package com.energopro.app.injection

import com.energopro.feature.injection.FeatureModule
import com.energopro.network.graphql.injection.NetworkGraphqlModule
import com.energopro.network.rest.injection.NetworkRestModule
import com.energopro.persistence.injection.persistenceModule
import com.energopro.platform.binding.PlatformBindings
import com.energopro.platform.injection.platformModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module

/**
 * Injection entry-point.
 * This object initialises dependency injection in application.
 */
internal object AppInjection {

    fun initializeInjection(
        platformBindings: PlatformBindings,
        appDeclaration: KoinAppDeclaration?,
    ) {
        startKoin {
            if (appDeclaration != null) {
                appDeclaration()
            }

            modules(
                platformModule(platformBindings = platformBindings),
                FeatureModule().module,
                NetworkGraphqlModule().module,
                NetworkRestModule().module,
                persistenceModule(),
            )
        }
    }
}
