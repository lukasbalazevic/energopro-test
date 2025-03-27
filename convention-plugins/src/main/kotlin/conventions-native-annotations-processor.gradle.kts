import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

// As of now, we cannot use Gradle version catalogs with Precompiled Script plugins: https://github.com/gradle/gradle/issues/15383
plugins {
    id("com.google.devtools.ksp")
}

ksp {
    // set to false because it doesn't support providing impl from different module
    // enable/disable compile time check
    arg("KOIN_CONFIG_CHECK","false")
    // disable default module generation
    arg("KOIN_DEFAULT_MODULE","false")
}

val libs = the<LibrariesForLibs>()

dependencies {
    ksp(libs.koin.ksp.compiler)
}
