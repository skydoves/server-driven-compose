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
  id("skydoves.android.library")
  id("skydoves.android.hilt")
  id(libs.plugins.kotlin.serialization.get().pluginId)
  id(libs.plugins.google.secrets.get().pluginId)
  id("skydoves.spotless")
}

android {
    namespace = "io.getstream.server.driven.core.network"

  buildFeatures {
    buildConfig = true
  }
}

dependencies {
  // module
  api(projects.core.model)

  // androidx
  implementation(libs.androidx.startup)

  // network
  api(libs.sandwich)
  api(libs.okhttp.logging)
  implementation(platform(libs.retrofit.bom))
  implementation(libs.retrofit)
  implementation(libs.retrofit.kotlinx.serialization)

  // serialization
  implementation(libs.kotlinx.serialization.json)

  // firebase
  implementation(platform(libs.firebase.bom))
  api(libs.firebase.database.ktx)
  api(libs.firebase.database)
}

secrets {
  propertiesFileName = "secrets.properties"
  defaultPropertiesFileName = "secrets.defaults.properties"
}