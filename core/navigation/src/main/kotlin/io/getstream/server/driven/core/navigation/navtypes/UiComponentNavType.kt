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
package io.getstream.server.driven.core.navigation.navtypes

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import io.getstream.server.driven.core.model.UiComponent
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object UiComponentNavType : NavType<UiComponent?>(isNullableAllowed = true) {

  private val json = Json

  override fun get(bundle: Bundle, key: String): UiComponent? {
    val stringValue = bundle.getString(key) ?: return null
    val component = json.decodeFromString<UiComponent>(stringValue)
    return component
  }

  override fun put(bundle: Bundle, key: String, value: UiComponent?) {
    val stringValue = json.encodeToString(value)
    bundle.putSerializable(key, stringValue)
  }

  override fun serializeAsValue(value: UiComponent?): String {
    // Serialized values must always be Uri encoded
    return Uri.encode(Json.encodeToString(value))
  }

  override fun parseValue(value: String): UiComponent? {
    // Navigation takes care of decoding the string
    // before passing it to parseValue()
    return Json.decodeFromString<UiComponent?>(value)
  }
}
