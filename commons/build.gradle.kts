import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(notation = libs.plugins.kotlinMultiplatform)
    alias(notation = libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "commons"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(dependencyNotation = libs.koin.android)
            implementation(dependencyNotation = libs.koin.androidx.compose)
        }
        commonMain.dependencies {
            // Put your Multiplatform Dependencies here...
            api(dependencyNotation = libs.koin.core)
            implementation(dependencyNotation = libs.koin.compose)
            implementation(dependencyNotation = libs.koin.compose.viewmodel)
        }
        commonTest.dependencies {
            implementation(dependencyNotation = libs.kotlin.test)
        }
    }
}

android {
    namespace = "thebookshelfproject.thebookshelfproject"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
