/*
 * Designed and developed by 2024 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
plugins {
  id("skydoves.android.application")
  id("skydoves.android.application.compose")
  id("skydoves.android.hilt")
  id("skydoves.spotless")
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "io.getstream.server.driven.compose"
  compileSdk = 35

  defaultConfig {
    applicationId = "io.getstream.server.driven.compose"
    minSdk = 24
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  kotlinOptions {
    jvmTarget = "17"
  }

  buildFeatures {
    compose = true
    buildConfig = true
  }

  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  // Cores
  implementation(projects.core.designsystem)
  implementation(projects.core.navigation)

  // Features
  implementation(projects.feature.timeline)
  implementation(projects.feature.details)

  // Compose
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.navigation.compose)
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.tooling.preview)
  implementation(libs.androidx.compose.runtime)
  implementation(libs.androidx.compose.foundation)
  implementation(libs.androidx.lifecycle.runtimeCompose)
  implementation(libs.androidx.lifecycle.viewModelCompose)
  implementation(libs.androidx.compose.material)
  implementation(libs.androidx.compose.material.iconsExtended)

  // Compose Image Loading
  implementation(libs.landscapist.glide)
  implementation(libs.landscapist.animation)
  implementation(libs.landscapist.placeholder)

  // Coroutines
  implementation(libs.kotlinx.coroutines.android)

  // Network
  implementation(libs.sandwich)
  implementation(libs.okhttp.logging)

  // Serialization
  implementation(libs.kotlinx.serialization.json)

  // Firebase
  implementation(platform(libs.firebase.bom))
  implementation(libs.firebase.store)
  implementation(libs.firebase.remote.config)
}

if (file("google-services.json").exists()) {
  apply(plugin = libs.plugins.gms.googleServices.get().pluginId)
}