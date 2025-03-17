package com.energopro.gradle.configuration

import org.gradle.api.JavaVersion

object ProjectSettings {

    object Gradle {
        const val TaskGroup = "futured"
    }

    object Kotlin {
        const val JvmToolchainVersion = 17
    }

    object Android {

        object Sales {
            const val ApplicationId = "com.energopro.sales.android"

            object Signing {
                object Debug {
                    val StorePassword = "android"
                    val KeyAlias = "androiddebugkey"
                    val KeyPassword = "android"
                }

                object Release {
                    val StorePassword = System.getenv("ANDROID_KEYSTORE_PASSWORD").orEmpty()
                    val KeyAlias = System.getenv("ANDROID_KEY_ALIAS").orEmpty()
                    val KeyPassword = System.getenv("ANDROID_KEY_PASSWORD").orEmpty()
                }
            }
        }

        object CustomerCare {
            const val ApplicationId = "com.energopro.customercare.android"

            object Signing {
                object Debug {
                    val StorePassword = "android"
                    val KeyAlias = "androiddebugkey"
                    val KeyPassword = "android"
                }

                object Release {
                    val StorePassword = System.getenv("ANDROID_KEYSTORE_PASSWORD").orEmpty()
                    val KeyAlias = System.getenv("ANDROID_KEY_ALIAS").orEmpty()
                    val KeyPassword = System.getenv("ANDROID_KEY_PASSWORD").orEmpty()
                }
            }
        }

        const val MinSdkVersion = 29
        const val TargetSdkVersion = 35
        const val CompileSdkVersion = 35



        val VersionCode = System.getenv("ANDROID_BUILD_NUMBER")?.toInt() ?: 1
        val VersionName = System.getenv("ANDROID_VERSION_NAME") ?: "1.0.0"

        val JavaCompatibility = JavaVersion.VERSION_17
        const val KotlinJvmTargetNum = "17"

        object BuildTypes {
            const val Debug = "debug"
            const val Enterprise = "enterprise"
            const val Release = "release"
        }


    }

    object IOS {
        const val FrameworkName = "KMP"
        const val FrameworkBundleId = "com.energopro.shared"
        const val MokoBaseLocalizationRegion = "en"
    }
}
