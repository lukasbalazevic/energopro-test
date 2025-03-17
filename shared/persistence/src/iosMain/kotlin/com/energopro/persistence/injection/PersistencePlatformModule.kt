package com.energopro.persistence.injection

import com.energopro.persistence.tools.SETTINGS_DATASTORE_FILENAME
import kotlinx.cinterop.ExperimentalForeignApi
import okio.Path.Companion.toPath
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
internal actual fun persistencePlatformModule() = module {
    single(Qualifiers.DataStorePath) {
        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )

        (requireNotNull(documentDirectory).path + "/$SETTINGS_DATASTORE_FILENAME").toPath()
    }
}
