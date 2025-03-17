package com.energopro.persistence.injection

import android.content.Context
import com.energopro.persistence.tools.SETTINGS_DATASTORE_FILENAME
import okio.Path.Companion.toPath
import org.koin.dsl.module

internal actual fun persistencePlatformModule() = module {
    single(Qualifiers.DataStorePath) {
        get<Context>().filesDir.resolve(SETTINGS_DATASTORE_FILENAME).absolutePath.toPath()
    }
}
