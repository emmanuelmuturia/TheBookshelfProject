/*
 * Copyright 2025 The Bookshelf Project
 *
 * Licenced under the Apache License, Version 2.0 (the "Licence");
 * you may not use this file except in compliance with the Licence.
 * You may obtain a copy of the Licence at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(notation = libs.plugins.kotlinMultiplatform)
    alias(notation = libs.plugins.androidLibrary)
    alias(notation = libs.plugins.ksp)
    alias(notation = libs.plugins.kotlin.serialization.json)
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
        iosSimulatorArm64(),
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
            implementation(dependencyNotation = libs.ktor.client.okhttp)
        }
        commonMain.dependencies {
            // Put your Multiplatform Dependencies here...
            api(dependencyNotation = libs.koin.core)
            implementation(dependencyNotation = libs.koin.compose)
            implementation(dependencyNotation = libs.koin.compose.viewmodel)
            implementation(dependencyNotation = libs.ktor.client.core)
            implementation(dependencyNotation = libs.kotlinx.coroutines.core)
            implementation(dependencyNotation = libs.timber)
            implementation(dependencyNotation = libs.lifecycle.viewmodel)
            implementation(dependencyNotation = libs.kotlin.serialization.json)
        }
        commonTest.dependencies {
            implementation(dependencyNotation = libs.kotlin.test)
        }
        iosMain.dependencies {
            implementation(dependencyNotation = libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "bookshelf.bookshelf"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}